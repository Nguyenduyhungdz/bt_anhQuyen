package com.oders.validator.demo.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int productId;

    @NotNull(message = "name không được để trống")
    @Column(length = 50)
    private String name;

    @Min(value = 0, message = "quanity  phải lớn hơn 0")
    private int quantityInStock;

    @OneToMany(mappedBy = "product",  fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "product_id" )
    private Set<OrderItemsEntity> orderItems;
}
