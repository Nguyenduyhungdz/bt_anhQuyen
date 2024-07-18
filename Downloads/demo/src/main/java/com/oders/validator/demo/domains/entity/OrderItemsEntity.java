package com.oders.validator.demo.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oders.validator.demo.domains.entity.keys.OrderProductKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemsEntity {

    @EmbeddedId
    OrderProductKey id;


    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id" , nullable = false,foreignKey = @ForeignKey(name = "fk_orderItem_order"))
    @JsonIgnoreProperties(value = "order")
    private OrderEntity order;


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id" , nullable = false,foreignKey = @ForeignKey(name = "fk_orderItem_product"))
    @JsonIgnoreProperties(value = "product")
    private ProductsEntity product;

    @Min(value =0 , message = "quantity phai lon hon 0")
    private int quantity;

    @Min(value =0 , message = "unitPrice phai lon hon 0")
    private double unitPrice;
}
