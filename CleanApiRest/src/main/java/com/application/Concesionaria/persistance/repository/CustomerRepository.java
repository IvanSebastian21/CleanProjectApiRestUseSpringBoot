package com.application.Concesionaria.persistance.repository;

import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.domain.repository.ICustomerRepository;
import com.application.Concesionaria.persistance.entity.CustomerEntity;
import com.application.Concesionaria.persistance.mapper.ICustomerMapper;
import com.application.Concesionaria.persistance.crud.ICustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa el repositorio para gestionar las operaciones relacionadas con los clientes.
 * <p>
 * Esta clase actúa como una capa intermedia entre el servicio y el CRUD Repository de clientes,
 * coordinando la conversión de datos entre DTO y entidades utilizando {@link ICustomerMapper}.
 */
@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;

    private final ICustomerMapper iCustomerMapper;

    /**
     * Obtiene una lista de todos los clientes registrados.
     *
     * @return Lista de {@link CustomerDto} que representan los clientes registrados.
     */
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomerDtoList(iCustomerCrudRepository.findAll());
    }

    /**
     * Obtiene un cliente específico según su cédula.
     *
     * @param cardId La cédula del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa al cliente encontrado (si existe).
     */
    @Override
    public Optional<CustomerDto> getCustomerDtoCarId(String cardId) {
        return iCustomerCrudRepository.findById(cardId).map(customerEntity -> iCustomerMapper.toCustomerDto(customerEntity));
    }

    /**
     * Obtiene un cliente específico según su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa al cliente encontrado (si existe).
     */
    @Override
    public Optional<CustomerDto> getCustomerDtoByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email).map(customerEntity -> iCustomerMapper.toCustomerDto(customerEntity));
    }

    /**
     * Guarda un nuevo cliente en el repositorio.
     *
     * @param newCustomerDto El {@link CustomerDto} que se va a guardar como un nuevo cliente.
     * @return El {@link CustomerDto} que representa al cliente guardado.
     */
    @Override
    public CustomerDto save(CustomerDto newCustomerDto) {
        CustomerEntity customerEntity = iCustomerMapper.toCustomerEntity(newCustomerDto);
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.save(customerEntity));
    }

    /**
     * Elimina un cliente según su cédula.
     *
     * @param cardId La cédula del cliente a eliminar.
     */
    @Override
    public void delete(String cardId) {
        iCustomerCrudRepository.deleteById(cardId);
    }

    @Override
    public void updatePassword(String cardId, String newPassword) {
        Optional<CustomerEntity> optionalCustomer = iCustomerCrudRepository.findById(cardId);
        if (optionalCustomer.isPresent()) {
            CustomerEntity customerEntity = optionalCustomer.get();
            customerEntity.setPassword(newPassword);
            iCustomerCrudRepository.save(customerEntity);
        }
    }

}
