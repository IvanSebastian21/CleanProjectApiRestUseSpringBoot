package com.application.Concesionaria.domain.repository;

import com.application.Concesionaria.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato del repositorio para la entidad {@link BrandCarDto}.
 * <p>
 * Este repositorio se encarga de gestionar las operaciones relacionadas con las marcas de coches.
 */
public interface IBrandCarRepository {

    /**
     * Obtiene una lista de todas las marcas de coches disponibles.
     *
     * @return Lista de {@link BrandCarDto} que representan las marcas de coches.
     */
    List<BrandCarDto> getAll();

    /**
     * Obtiene una marca de coche específica según su identificador.
     *
     * @param id El identificador único de la marca de coche a buscar.
     * @return Una instancia de {@link BrandCarDto} que representa la marca de coche encontrada (si existe).
     */
    Optional<BrandCarDto> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca de coche en el repositorio.
     *
     * @param newBrandCar El {@link BrandCarDto} que se va a guardar como una nueva marca de coche.
     * @return El {@link BrandCarDto} que representa la marca de coche guardada.
     */
    BrandCarDto save(BrandCarDto newBrandCar);

    /**
     * Elimina una marca de coche según su identificador.
     *
     * @param idBrandCar El identificador único de la marca de coche a eliminar.
     */
    void delete(Integer idBrandCar);

}
