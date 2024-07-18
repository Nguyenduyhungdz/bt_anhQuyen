package com.oders.validator.demo.mappers.Impl;


import com.oders.validator.demo.domains.dto.OrderDto;
import com.oders.validator.demo.domains.entity.OrderEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements Mapper<OrderEntity, OrderDto> {
    private ModelMapper modelMapper;

    public OrderMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDto mapTo(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderEntity mapFrom(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderEntity.class);
    }
}

