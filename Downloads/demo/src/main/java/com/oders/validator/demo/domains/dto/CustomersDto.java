package com.oders.validator.demo.domains.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oders.validator.demo.utils.validate.PhoneNumber;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomersDto {
    @Min(value = 0, message = "customor_id lớn hơn hoặc bằng 0")
    private int customer_id;

    @NotBlank(message = "firstname must not be blank")
    private String first_name;

    @NotNull(message = "lastname must not be null")
    private String last_name;

    @NotNull(message = "dateOfBirth must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date birth_date;

    @PhoneNumber
    private String phone;

    @NotNull(message = "address must not be null")
    private String address;

    @NotNull(message = "city must not be null")
    private String city;

    @NotNull(message = "state must not be null")
    private String state;

    @NotNull(message = "points must not be null")
    @Min(value = 0, message = "points lớn hơn hoặc bằng 0")
    private int points;

}
