package com.application.Concesionaria.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase que representa un DTO (Data Transfer Object) para la entidad de cliente.
 *
 * Esta clase se utiliza para transferir datos entre las capas de la aplicación y
 * proporciona una vista simplificada de los campos de la entidad de cliente.
 */
@ToString
@Getter
@Setter
public class CustomerDto {
    private String cardId;
    private String fullName;
    private String email;
    private Integer numberCellPhone;
    private Integer active;
    private String password;

}
