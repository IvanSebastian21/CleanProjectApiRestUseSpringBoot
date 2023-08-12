package com.application.Concesionaria.domain.repository;

import com.application.Concesionaria.domain.dto.BrandCarDto;
import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.domain.dto.PasswordGenerationDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato del repositorio para la entidad {@link CustomerDto}.
 * <p>
 * Este repositorio se encarga de gestionar las operaciones relacionadas con los clientes.
 */
public interface ICustomerRepository {
    /**
     * Obtiene una lista de todas los clientes.
     *
     * @return Lista de {@link CustomerDto} que representan los clientes.
     */
    List<CustomerDto> getAll();

    /**
     * Obtiene un cliente específico según su identificador.
     *
     * @param cardId El identificador único del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa el cliente encontrado (si existe).
     */
    Optional<CustomerDto> getCustomerDtoCarId(String cardId);

    /**
     * Obtiene un cliente específico según su identificador.
     *
     * @param email El identificador único del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa el cliente encontrado (si existe).
     */
    Optional<CustomerDto> getCustomerDtoByEmail(String email);

    /**
     * Guarda un nuevo cliente en el repositorio.
     *
     * @param newCustomerDto El {@link BrandCarDto} que se va a guardar como un nuevo cliente.
     * @return El {@link BrandCarDto} que representa al cliente guardado.
     */
    CustomerDto save(CustomerDto newCustomerDto);

    /**
     * Actualiza la contraseña de un cliente según su identificador.
     *
     * @param cardId El identificador único del cliente cuya contraseña se actualizará.
     * @param newPassword La nueva contraseña a asignar.
     */
    void updatePassword(String cardId, String newPassword);

    /**
     * Elimina un cliente según su identificador.
     *
     * @param cardId El identificador único del cliente a eliminar.
     */
    void delete(String cardId);

}
