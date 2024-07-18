package com.oders.validator.demo.controllers;

import com.oders.validator.demo.domains.dto.ProductsDto;
import com.oders.validator.demo.domains.entity.ProductsEntity;
import com.oders.validator.demo.mappers.Mapper;
import com.oders.validator.demo.services.ProductsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/product")
@Validated
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private Mapper<ProductsEntity, ProductsDto> productsMapper;

    public ProductController(ProductsService productsService, Mapper<ProductsEntity, ProductsDto> productsMapper) {
        this.productsMapper = productsMapper;
        this.productsService = productsService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ProductsDto> createProduct(@Valid @RequestBody ProductsDto products) {
        ProductsEntity productsEntity = productsMapper.mapFrom(products);
        ProductsEntity saveProductEntity = productsService.save(productsEntity);
        return new ResponseEntity<>(productsMapper.mapTo(saveProductEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public List<ProductsDto> listProduct() {
        List<ProductsEntity> products = productsService.ListAll();
        return products.stream().map(productsMapper::mapTo).collect(Collectors.toList());
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ProductsDto> partialUpdateProduct(@Min(1) @PathVariable("id") int id, @RequestBody ProductsDto productsDto) {
        // check xem có tồn tại id hay không
        if (!productsService.isXist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // nếu tồn tại thì update
        ProductsEntity productsEntity = productsMapper.mapFrom(productsDto);
        ProductsEntity updateProductEntity = productsService.partialUpdate(id, productsEntity);
        ProductsDto updateProductDto = productsMapper.mapTo(updateProductEntity);
        return new ResponseEntity<>(updateProductDto, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductsDto> createUpdateProduct(@PathVariable("id") int id, @RequestBody ProductsDto productsDto) {
        ProductsEntity productsEntity = productsMapper.mapFrom(productsDto);
        boolean productExist = productsService.isXist(id);
        ProductsEntity saveProductEntity = productsService.createUpdateProduct(id, productsEntity);
        ProductsDto saveProductDto = productsMapper.mapTo(saveProductEntity);

        if (productExist) {
            return new ResponseEntity<>(saveProductDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(saveProductDto, HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductsDto> getProductId(@PathVariable("id") int id) {
        Optional<ProductsEntity> foundProduct = productsService.FindOne(id);
        return foundProduct.map(productsEntity -> {
            ProductsDto productsDto = productsMapper.mapTo(productsEntity);
            return new ResponseEntity<>(productsDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ProductsDto> deleteProduct(@PathVariable("id") int id){
        productsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
