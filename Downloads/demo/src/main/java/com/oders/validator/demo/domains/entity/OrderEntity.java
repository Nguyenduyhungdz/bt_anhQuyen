package com.oders.validator.demo.domains.entity;

//import com.oders.validator.demo.utils.validate.Enum_valid.OrderStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oders.validator.demo.utils.validate.EnumPattern;
import com.oders.validator.demo.utils.validate.Enum_valid.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @NotNull(message = "orderDate must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date orderDate;

    @NotNull(message = "comments không được để trống")
    @Column(length = 2000)
    private String comments;

    @NotNull(message = "shipperDate must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date shipedDate;


    @ManyToOne
    @JoinColumn(name = "status" , nullable = false,foreignKey = @ForeignKey(name = "fk_order_status"))
    @JsonIgnoreProperties(value = "orderEntities")
    private OrderStatusesEntity orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false,foreignKey = @ForeignKey(name = "fk_order_customer"))
    @JsonIgnoreProperties(value = "orderEntities")
    private CustomersEntity customer;

    @ManyToOne
    @JoinColumn(name = "shipper_id" , nullable = false,foreignKey = @ForeignKey(name = "fk_order_shipper"))
    @JsonIgnoreProperties(value = "orderEntities")
    private ShipperEntity shipper;


    @OneToMany(mappedBy = "order",  fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "order_id" )
    private Set<OrderItemsEntity> orderItems;



}
