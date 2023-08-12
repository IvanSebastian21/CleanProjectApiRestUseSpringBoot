package com.application.Concesionaria.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa una marca de coche (Entidad).
 * <p>
 * Esta clase es un DTO (Data Transfer Object) que contiene información sobre una marca de coche,
 * incluyendo un identificador único y una descripción.
 */

@Getter
@Setter
public class BrandCarDto {

    /**
     * Identificador único de la marca de coche.
     */
    private Integer id;

    /**
     * Descripción de la marca de coche.
     */
    private String description;
}
