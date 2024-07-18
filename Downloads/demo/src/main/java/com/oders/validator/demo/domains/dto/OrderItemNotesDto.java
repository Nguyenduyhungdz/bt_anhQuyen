package com.oders.validator.demo.domains.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderItemNotesDto {

    @Min(value = 0, message = "note_id phải lớn hơn hoặc bằng 0")
    private int note_id;

    @Min(value = 0, message = "order_id phải lớn hơn hoặc bằng 0")
    private int order_id;

    @Min(value = 0, message = "product_id phải lớn hơn hoặc bằng 0")
    private int product_id;

    @NotNull(message = "note must not be null")
    private String note;
}
