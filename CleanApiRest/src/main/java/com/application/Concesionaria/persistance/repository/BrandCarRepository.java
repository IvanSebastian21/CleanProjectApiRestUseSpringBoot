package com.application.Concesionaria.persistance.repository;

import com.application.Concesionaria.domain.dto.BrandCarDto;
import com.application.Concesionaria.domain.repository.IBrandCarRepository;
import com.application.Concesionaria.persistance.entity.BrandCarEntity;
import com.application.Concesionaria.persistance.mapper.IBrandCarMapper;
import com.application.Concesionaria.persistance.crud.IBrandCarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa el repositorio para gestionar las operaciones relacionadas con las marcas de coches.
 * <p>
 * Esta clase utiliza Spring Data JPA para interactuar con la base de datos y el mapeador {@link IBrandCarMapper}
 * para convertir entre entidades y Dto´s.
 */
@RequiredArgsConstructor
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    private final IBrandCarMapper iBrandCarMapper;


    /**
     * Obtiene una lista de todas las marcas de coches disponibles.
     *
     * @return Lista de {@link BrandCarDto} que representan las marcas de coches.
     */
    @Override
    public List<BrandCarDto> getAll() {
        // La implementación de este método debería obtener todas las entidades de marcas de coches
        // utilizando iBrandCarCrudRepository y luego mapearlas a Dtos utilizando iBrandCarMapper.
        return iBrandCarMapper.toMarcasCocheDtoList(iBrandCarCrudRepository.findAll());
    }

    /**
     * Obtiene una marca de coche específica según su identificador.
     *
     * @param id El identificador único de la marca de coche a buscar.
     * @return Una instancia de {@link BrandCarDto} que representa la marca de coche encontrada (si existe).
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        // La implementación de este método debería obtener la entidad de marca de coche con el id proporcionado
        // utilizando iBrandCarCrudRepository, y luego mapearla a un Dto utilizando iBrandCarMapper.
        return iBrandCarCrudRepository
                .findById(id)
                .map(brandCarEntity -> iBrandCarMapper.toMarcaCocheDto(brandCarEntity)); //lambda
        //.map(iBrandCarMapper::toMarcaCocheDto);  Método por referencia
    }

    /**
     * Guarda una nueva marca de coche en el repositorio.
     *
     * @param newBrandCar El {@link BrandCarDto} que se va a guardar como una nueva marca de coche.
     * @return El {@link BrandCarDto} que representa la marca de coche guardada.
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        // La implementación de este método debería convertir el Dto newBrandCar en una entidad utilizando
        // iBrandCarMapper y luego guardarla en la base de datos utilizando iBrandCarCrudRepository.
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCocheDto(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca de coche según su identificador.
     *
     * @param idBrandCar El identificador único de la marca de coche a eliminar.
     */
    @Override
    public void delete(Integer idBrandCar) {
        // La implementación de este método debería eliminar la entidad de marca de coche con el id proporcionado
        // utilizando iBrandCarCrudRepository.
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}

