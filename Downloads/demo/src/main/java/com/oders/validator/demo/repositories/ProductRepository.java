package com.oders.validator.demo.repositories;

import com.oders.validator.demo.domains.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Integer> {

}
