package com.oders.validator.demo.domains.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderProductKey implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

}
