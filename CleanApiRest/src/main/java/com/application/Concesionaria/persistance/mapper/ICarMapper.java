package com.application.Concesionaria.persistance.mapper;

import com.application.Concesionaria.domain.dto.CarDto;
import com.application.Concesionaria.persistance.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {
    CarDto toCarDto(CarEntity carEntity);
    @Mapping(target = "brandCarEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);
    List<CarDto> toCarsDtoList(List<CarEntity> carEntityList);

}
