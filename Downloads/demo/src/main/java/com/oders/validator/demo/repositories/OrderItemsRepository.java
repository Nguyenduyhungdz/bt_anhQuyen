package com.oders.validator.demo.repositories;

import com.oders.validator.demo.domains.entity.OrderItemsEntity;
import com.oders.validator.demo.domains.entity.keys.OrderProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, OrderProductKey> {
}
