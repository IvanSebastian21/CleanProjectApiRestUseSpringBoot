package com.application.Concesionaria.domain.useCase;

import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.domain.dto.PasswordGenerationDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos para gestionar las operaciones relacionadas con los clientes.
 * <p>
 * Esta interfaz proporciona una abstracción de los servicios que se pueden realizar sobre los clientes,
 * como obtener todos los clientes, buscar un cliente por cédula o correo electrónico, guardar un nuevo
 * cliente, actualizar un cliente existente y eliminar un cliente por su cédula.
 */
public interface ICustomerService {
    /**
     * Obtiene una lista de todos los clientes registrados.
     *
     * @return Lista de {@link CustomerDto} que representan los clientes registrados.
     */
    List<CustomerDto> getAll();

    /**
     * Obtiene un cliente específico según su cédula.
     *
     * @param cardId La cédula del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa al cliente encontrado (si existe).
     */
    Optional<CustomerDto> getCustomerDtoCarId(String cardId);

    /**
     * Obtiene un cliente específico según su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa al cliente encontrado (si existe).
     */
    Optional<CustomerDto> getCustomerDtoByEmail(String email);

    /**
     * Guarda un nuevo cliente en el repositorio.
     *
     * @param newCustomerDto El {@link CustomerDto} que se va a guardar como un nuevo cliente.
     * @return El {@link CustomerDto} que representa al cliente guardado.
     */
    CustomerDto save(CustomerDto newCustomerDto);

    PasswordGenerationDto getPasswordGenerationDto(CustomerDto passwordGenerationDto);

    /**
     * Actualiza un cliente existente en el repositorio.
     *
     * @param newCustomerDto El {@link CustomerDto} que representa al cliente actualizado.
     * @return Una instancia de {@link CustomerDto} que representa al cliente actualizado (si existe).
     * Si el cliente no existe, devuelve un Optional vacío.
     */
    Optional<CustomerDto> update(CustomerDto newCustomerDto);

    /**
     * Elimina un cliente según su cédula.
     *
     * @param cardId La cédula del cliente a eliminar.
     * @return True si el cliente fue eliminado correctamente, False si el cliente no existe en el repositorio.
     */
    boolean delete(String cardId);
}
