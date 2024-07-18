package com.oders.validator.demo.mappers.Impl;

import com.oders.validator.demo.domains.dto.OrderItemNotesDto;
import com.oders.validator.demo.domains.entity.OrderItemNotesEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemNoteMapperImpl implements Mapper<OrderItemNotesEntity, OrderItemNotesDto> {
    private ModelMapper modelMapper;

    public OrderItemNoteMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemNotesDto mapTo(OrderItemNotesEntity order_item_notesEntity) {
        return modelMapper.map(order_item_notesEntity, OrderItemNotesDto.class);
    }

    @Override
    public OrderItemNotesEntity mapFrom(OrderItemNotesDto order_item_notesDto) {
        return modelMapper.map(order_item_notesDto, OrderItemNotesEntity.class);
    }
}