package com.oders.validator.demo.mappers.Impl;

import com.oders.validator.demo.domains.dto.OrderStatusesDto;
import com.oders.validator.demo.domains.entity.OrderStatusesEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusMapperImpl implements Mapper<OrderStatusesEntity, OrderStatusesDto> {
    private ModelMapper modelMapper;

    public OrderStatusMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderStatusesDto mapTo(OrderStatusesEntity order_statusesEntity) {
        return modelMapper.map(order_statusesEntity, OrderStatusesDto.class);
    }

    @Override
    public OrderStatusesEntity mapFrom(OrderStatusesDto order_statusesDto) {
        return modelMapper.map(order_statusesDto, OrderStatusesEntity.class);
    }
}