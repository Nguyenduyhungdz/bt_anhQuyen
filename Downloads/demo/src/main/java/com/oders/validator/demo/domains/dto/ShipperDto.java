package com.oders.validator.demo.domains.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShipperDto {

    @Min(value = 0, message = "shipper_id phải lớn hơn hoặc bằng 0")
    private int shipper_id;

    @NotBlank(message = "name must not be blank")
    @NotNull(message = "name must not be null")
    private String name;
}
