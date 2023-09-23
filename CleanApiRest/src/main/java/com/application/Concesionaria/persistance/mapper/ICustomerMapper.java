package com.application.Concesionaria.persistance.mapper;

import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Interfaz que define el mapeo entre la entidad {@link CustomerEntity} y el DTO {@link CustomerDto}.
 * <p>
 * Esta interfaz utiliza MapStruct para generar automáticamente el código de mapeo entre las entidades y los DTO.
 * La anotación {@link Mapper} con el atributo "componentModel = "spring"" indica que se utilizara el inyector de
 * dependencias de Spring para administrar el componente generado.
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    /**
     * Convierte una entidad {@link CustomerEntity} en un DTO {@link CustomerDto}.
     *
     * @param customerEntity La entidad {@link CustomerEntity} a convertir.
     * @return El DTO {@link CustomerDto} que representa la entidad.
     * <p>
     */
    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    /**
     * Convierte un DTO {@link CustomerDto} en una entidad {@link CustomerEntity}.
     *
     * @param customerDto El DTO {@link CustomerDto} a convertir.
     * @return La entidad {@link CustomerEntity} que representa el DTO.
     */
    // Agregar función para asignar cardId en la entidad a partir del DTO
    @Mapping(target = "cardId", source = "cardId")
    @Mapping(target = "carPurchaseEntityList", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    /**
     * Convierte una lista de entidades {@link CustomerEntity} en una lista de DTO {@link CustomerDto}.
     *
     * @param customerEntityList La lista de entidades {@link CustomerEntity} a convertir.
     * @return La lista de DTO {@link CustomerDto} que representan las entidades.
     */
    List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntityList);
}
