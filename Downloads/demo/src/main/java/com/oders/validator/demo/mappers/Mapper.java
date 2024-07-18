package com.oders.validator.demo.mappers;

import com.oders.validator.demo.domains.dto.CustomersDto;
import com.oders.validator.demo.domains.dto.OrderDto;
import com.oders.validator.demo.domains.entity.CustomersEntity;
import com.oders.validator.demo.domains.entity.OrderEntity;

public interface Mapper <A , B>{
    B mapTo (A a);
    A mapFrom(B b);
}
