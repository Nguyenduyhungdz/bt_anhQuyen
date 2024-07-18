package com.oders.validator.demo.domains.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order_items_note")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemNotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int noteId;

    @Column(nullable = false)
    private int orderId;

    @Column(nullable = false)
    private int productId;

    @NotNull(message = "note must not be null")
    @Column(length = 255)
    private String note;
}
