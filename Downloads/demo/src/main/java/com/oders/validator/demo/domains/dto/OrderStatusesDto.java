package com.oders.validator.demo.domains.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderStatusesDto {

    @Min(value = 0 , message = "order_status_id phải lớn hơn hoặc bằng 0")
    private int order_status_id;

    @NotNull(message = "name không được để trống ")
    private String name;
}
