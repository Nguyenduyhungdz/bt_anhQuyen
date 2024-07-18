package com.oders.validator.demo.services;

import com.oders.validator.demo.domains.entity.ProductsEntity;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    ProductsEntity save(ProductsEntity productsEntity);

    List<ProductsEntity> ListAll();

    boolean isXist(int id);

    ProductsEntity partialUpdate(int id, ProductsEntity productsEntity);

    Optional<ProductsEntity> FindOne(int id);

    void delete(int id);

    ProductsEntity createUpdateProduct(int id, ProductsEntity productsEntity);
}









