package com.application.Concesionaria.domain.useCase;

import com.application.Concesionaria.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato del servicio para gestionar las operaciones relacionadas con las marcas de coches.
 * <p>
 * Este servicio se encarga de coordinar la lógica de negocio y actuar como una capa intermedia entre el controlador
 * y el repositorio de marcas de coches.
 */
public interface IBrandCarService {

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
     * Modifica una nueva marca de coche en el repositorio.
     *
     * @param newBrandCar El {@link BrandCarDto} que se va a guardar como una nueva marca de coche.
     * @return El {@link BrandCarDto} que representa la marca de coche guardada.
     */
    Optional<BrandCarDto> update(BrandCarDto newBrandCar);

    /**
     * Elimina una marca de coche según su identificador.
     *
     * @param idBrandCar El identificador único de la marca de coche a eliminar.
     */
    boolean delete(Integer idBrandCar);

}
