package com.oders.validator.demo.domains.dto;

//import com.oders.validator.demo.utils.validate.Enum_valid.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.oders.validator.demo.utils.validate.EnumPattern;
import com.oders.validator.demo.utils.validate.Enum_valid.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDto {
    @Min(value = 0, message = "id lớn hơn hoặc bằng 0")
    private int id;

    @Min(value = 0, message = "customor_id lớn hơn hoặc bằng 0")
    private int customer_id;

    @NotNull(message = "orderDate must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date order_date;

    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private OrderStatus order_status;
    //    private OrderStatus order_status;

    @NotNull(message = "comments không được để trống")
    private String comments;

    @NotNull(message = "shipperDate must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date shiped_date;

    @Min(value = 0, message = "shipper_id lớn hơn hoặc bằng 0")
    private int shipper_id;
}
