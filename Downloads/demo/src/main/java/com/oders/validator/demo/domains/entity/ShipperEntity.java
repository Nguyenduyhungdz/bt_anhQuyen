package com.oders.validator.demo.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_shipper")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShipperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int shipperId;

    @NotNull(message = "name must not be null")
    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "shipper" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "shipper_id")
    private Set<OrderEntity> orderEntities;
}
