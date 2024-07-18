package com.oders.validator.demo.services.Impl;

import com.oders.validator.demo.domains.entity.ProductsEntity;
import com.oders.validator.demo.repositories.ProductRepository;
import com.oders.validator.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {


    @Autowired
    private ProductRepository productRepository;

    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductsEntity save(ProductsEntity productsEntity) {
        return productRepository.save(productsEntity);
    }

    @Override
    public List<ProductsEntity> ListAll() {
        return List.of();
    }


    @Override
    public boolean isXist(int id) {
        return productRepository.existsById(id);
    }

    @Override
    public ProductsEntity partialUpdate(int id, ProductsEntity productsEntity) {
        productsEntity.setProductId(id);
        return productRepository.findById(id).map(existingProduct -> {
            Optional.ofNullable(productsEntity.getName()).ifPresent(existingProduct::setName);
            Optional.ofNullable(productsEntity.getQuantityInStock()).ifPresent(existingProduct::setQuantityInStock);
            return productRepository.save(existingProduct);
        }).orElseThrow(() -> new RuntimeException("Author không tồn tại 111"));
    }

    @Override
    public Optional<ProductsEntity> FindOne(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }


    @Override
    public ProductsEntity createUpdateProduct(int id, ProductsEntity productsEntity) {
        return productRepository.save(productsEntity);
    }


}

