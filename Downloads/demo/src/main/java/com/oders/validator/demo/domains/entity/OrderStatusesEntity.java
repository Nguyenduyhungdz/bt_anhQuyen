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
@Table(name = "tb_order_statuses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderStatusesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private int orderStatusId;

    @NotNull(message = "name không được để trống ")
    @Column(length = 255)
    private String name;

    @OneToMany(mappedBy = "orderStatus" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "status")
    private Set<OrderEntity> orderEntities;

}
