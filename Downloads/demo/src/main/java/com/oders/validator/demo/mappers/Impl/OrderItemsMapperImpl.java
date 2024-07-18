package com.oders.validator.demo.mappers.Impl;

import com.oders.validator.demo.domains.dto.OrderItemsDto;
import com.oders.validator.demo.domains.entity.OrderItemsEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemsMapperImpl implements Mapper<OrderItemsEntity, OrderItemsDto> {
    private ModelMapper modelMapper;

    public OrderItemsMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemsDto mapTo(OrderItemsEntity order_itemsEntity) {
        return modelMapper.map(order_itemsEntity, OrderItemsDto.class);
    }

    @Override
    public OrderItemsEntity mapFrom(OrderItemsDto order_itemsDto) {
        return modelMapper.map(order_itemsDto, OrderItemsEntity.class);
    }
}