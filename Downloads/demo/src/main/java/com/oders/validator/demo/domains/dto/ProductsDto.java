package com.oders.validator.demo.domains.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductsDto {

    @Min(value = 0, message = "product_id phải lớn hoặc bằng 0")
    private int product_id;

    @NotNull(message = "name không được để trống")
    private String name;

    @Min(value = 1 , message = "quanity  phải lớn hơn 1")
    private int quanity_in_stock;

}
