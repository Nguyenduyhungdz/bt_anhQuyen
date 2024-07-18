package com.oders.validator.demo.domains.dto;

import jakarta.validation.constraints.Min;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderItemsDto {

    @Min(value = 0 , message = "order_id phải lớn hơn hoặc bằng 0 ")
    private int order_id;

    @Min(value = 0 , message = "order_id phải lớn hơn hoặc bằng 0 ")
    private int product_id;

    @Min(value = 1 , message = "order_id phải lớn hơn 0 ")
    private int quanity;

    @Min(value = 0 , message = "unit price phai lon hon 0")
    private double unit_price;
}
