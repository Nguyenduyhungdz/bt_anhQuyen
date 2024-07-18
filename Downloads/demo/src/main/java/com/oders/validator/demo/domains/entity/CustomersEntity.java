package com.oders.validator.demo.domains.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oders.validator.demo.utils.validate.PhoneNumber;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private int customerId;

    @NotNull(message = "lastname must not be null")
    @Column(length = 50)
    private String firstName;

    @NotNull(message = "lastname must not be null")
    @Column(length = 50)
    private String lastName;

    @NotNull(message = "dateOfBirth must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date birthDate;

    @PhoneNumber
    @Column(length = 50)
    private String phone;

    @NotNull(message = "address must not be null")
    @Column(length = 50)
    private String address;

    @NotNull(message = "city must not be null")
    @Column(length = 50)
    private String city;

    @NotNull(message = "state must not be null")
    @Column(length = 2)
    private String state;

    @Min(value = 0, message = "points lớn hơn hoặc bằng 0")
    private int points;

    @OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "customer_id")
    private Set<OrderEntity> orderEntities;
}
