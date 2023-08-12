package com.application.Concesionaria.persistance.mapper;

import com.application.Concesionaria.domain.dto.BrandCarDto;
import com.application.Concesionaria.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Interfaz que define las operaciones de mapeo entre la entidad MarcaCocheEntity y el Dto MarcaCocheDto.
 * <p>
 * Utilizamos la biblioteca MapStruct para generar automáticamente las implementaciones de los métodos de mapeo.
 * Esta interfaz permite convertir entre objetos de la entidad MarcaCocheEntity y el Dto MarcaCocheDto de manera sencilla.
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {
    /**
     * Convierte una entidad MarcaCocheEntity en un Dto MarcaCocheDto.
     *
     * @param marcaCocheEntity La entidad MarcaCocheEntity a convertir.
     * @return El Dto MarcaCocheDto resultante.(convertido)
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarDto toMarcaCocheDto(BrandCarEntity marcaCocheEntity);

    /**
     * Convierte un DTO MarcaCocheDto en una entidad MarcaCocheEntity.
     * <p>
     * Este método realiza el mapeo inverso al método toMarcaCocheDto, permitiendo convertir un Dto en una entidad.
     *
     * @param marcaCocheDto El DTO MarcaCocheDto a convertir.
     * @return La entidad MarcaCocheEntity resultante.(convertido)
     */
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarDto marcaCocheDto);

    /**
     * Convierte una lista de instancias de {@link BrandCarEntity} en una lista de {@link BrandCarDto}.
     *
     * @param toMarcasCocheEntityList La lista de entidades de marcas de coche.
     * @return La lista de DTO que representan las marcas de coche.
     */
    List<BrandCarDto> toMarcasCocheDtoList(List<BrandCarEntity> toMarcasCocheEntityList);

}
