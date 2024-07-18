package com.oders.validator.demo.mappers.Impl;


import com.oders.validator.demo.domains.dto.CustomersDto;
import com.oders.validator.demo.domains.dto.OrderDto;
import com.oders.validator.demo.domains.entity.CustomersEntity;
import com.oders.validator.demo.domains.entity.OrderEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements Mapper<CustomersEntity, CustomersDto> {
    private ModelMapper modelMapper;

    public CustomerMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomersDto mapTo(CustomersEntity customersEntity) {
        return modelMapper.map(customersEntity, CustomersDto.class);
    }

    @Override
    public CustomersEntity mapFrom(CustomersDto customersDto) {
        return null;
    }


}

