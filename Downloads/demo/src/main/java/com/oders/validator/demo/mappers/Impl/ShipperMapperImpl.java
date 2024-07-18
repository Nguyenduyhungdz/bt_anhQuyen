package com.oders.validator.demo.mappers.Impl;

import com.oders.validator.demo.domains.dto.OrderDto;
import com.oders.validator.demo.domains.dto.ShipperDto;
import com.oders.validator.demo.domains.entity.OrderEntity;
import com.oders.validator.demo.domains.entity.ShipperEntity;
import com.oders.validator.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ShipperMapperImpl implements Mapper<ShipperEntity, ShipperDto> {
    private ModelMapper modelMapper;

    public ShipperMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ShipperDto mapTo(ShipperEntity shipperEntity) {
        return modelMapper.map(shipperEntity, ShipperDto.class);
    }

    @Override
    public ShipperEntity mapFrom(ShipperDto shipperDto) {
        return modelMapper.map(shipperDto, ShipperEntity.class);
    }
}
