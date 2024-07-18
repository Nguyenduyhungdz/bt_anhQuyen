package com.oders.validator.demo.repositories;

import com.oders.validator.demo.domains.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,  Long> {
}
