package com.application.Concesionaria.domain.service;

import com.application.Concesionaria.domain.dto.BrandCarDto;
import com.application.Concesionaria.domain.repository.IBrandCarRepository;
import com.application.Concesionaria.domain.useCase.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa el servicio para gestionar las operaciones relacionadas con las marcas de coches.
 * <p>
 * Esta clase actúa como una capa intermedia entre el controlador y el repositorio de marcas de coches,
 * coordinando la lógica de negocio y utilizando para interactuar con los datos.
 */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService {

    private final IBrandCarRepository iBrandCarRepository;

    /**
     * Obtiene una lista de todas las marcas de coches disponibles.
     *
     * @return Lista de {@link BrandCarDto} que representan las marcas de coches.
     */
    @Override
    public List<BrandCarDto> getAll() {
        // La implementación de este método debería llamar al método getAll() del repositorio
        // iBrandCarRepository para obtener todas las marcas de coches disponibles.
        return iBrandCarRepository.getAll();
    }

    /**
     * Obtiene una marca de coche específica según su identificador.
     *
     * @param id El identificador único de la marca de coche a buscar.
     * @return Una instancia de {@link BrandCarDto} que representa la marca de coche encontrada (si existe).
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        // La implementación de este método debería llamar al método getBrandCar() del repositorio
        // iBrandCarRepository para obtener la marca de coche correspondiente al id proporcionado.
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * Guarda una nueva marca de coche en el repositorio.
     *
     * @param newBrandCar El {@link BrandCarDto} que se va a guardar como una nueva marca de coche.
     * @return El {@link BrandCarDto} que representa la marca de coche guardada.
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        // La implementación de este método debería llamar al método save() del repositorio
        // iBrandCarRepository para guardar la nueva marca de coche.
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     * Modifica una nueva marca de coche en el repositorio.
     *
     * @param newBrandCar El {@link BrandCarDto} que se va a guardar como una nueva marca de coche.
     * @return El {@link BrandCarDto} que representa la marca de coche guardada.
     */
    @Override
    public Optional<BrandCarDto> update(BrandCarDto newBrandCar) {
        // La implementación de este método debería llamar al método save() del repositorio
        // iBrandCarRepository para guardar la nueva modificación marca de coche.
        if (iBrandCarRepository.getBrandCar(newBrandCar.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(newBrandCar));
    }

    /**
     * Elimina una marca de coche según su identificador.
     *
     * @param idBrandCar El identificador único de la marca de coche a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} si no se encontró la marca de coche.
     */
    @Override
    public boolean delete(Integer idBrandCar) {
        // La implementación de este método debería llamar al método delete() del repositorio
        // iBrandCarRepository para eliminar la marca de coche correspondiente al id proporcionado.
//        try {
//            iBrandCarRepository.delete(idBrandCar);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        if (iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()){
            return false;
        }

        iBrandCarRepository.delete(idBrandCar);
        return true;

    }
}
