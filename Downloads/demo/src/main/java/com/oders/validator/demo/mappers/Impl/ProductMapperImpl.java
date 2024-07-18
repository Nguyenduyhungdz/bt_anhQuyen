package com.oders.validator.demo.mappers.Impl;

import com.oders.validator.demo.domains.dto.ProductsDto;
import com.oders.validator.demo.domains.entity.ProductsEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements Mapper<ProductsEntity, ProductsDto> {
    private ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductsDto mapTo(ProductsEntity productsEntity) {
        return modelMapper.map(productsEntity, ProductsDto.class);
    }

    @Override
    public ProductsEntity mapFrom(ProductsDto productsDto) {
        return modelMapper.map(productsDto, ProductsEntity.class);
    }
}