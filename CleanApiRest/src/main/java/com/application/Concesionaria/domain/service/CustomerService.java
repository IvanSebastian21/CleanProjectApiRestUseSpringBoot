package com.application.Concesionaria.domain.service;

import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.domain.dto.PasswordGenerationDto;
import com.application.Concesionaria.domain.repository.ICustomerRepository;
import com.application.Concesionaria.domain.useCase.ICustomerService;
import com.application.Concesionaria.exception.validators.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa el servicio para gestionar las operaciones relacionadas con los clientes.
 * <p>
 * Esta clase actúa como una capa intermedia entre el controlador y el repositorio de clientes,
 * proporcionando métodos para realizar las operaciones de negocio y coordinando la interacción
 * con el repositorio de clientes.
 */
@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    /**
     * Constructor de la clase CustomerService.
     *
     * @param iCustomerRepository El repositorio de clientes a utilizar para interactuar con la base de datos.
     */
    private final ICustomerRepository iCustomerRepository;

    /**
     * Obtiene una lista de todos los clientes registrados.
     *
     * @return Lista de {@link CustomerDto} que representan los clientes registrados.
     */
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    /**
     * Obtiene un cliente específico según su cédula.
     *
     * @param cardId La cédula del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa al cliente encontrado (si existe).
     */
    @Override
    public Optional<CustomerDto> getCustomerDtoCarId(String cardId) {

        return iCustomerRepository.getCustomerDtoCarId(cardId);
    }

    /**
     * Obtiene un cliente específico según su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del cliente a buscar.
     * @return Una instancia de {@link CustomerDto} que representa al cliente encontrado (si existe).
     */
    @Override
    public Optional<CustomerDto> getCustomerDtoByEmail(String email) {
        return iCustomerRepository.getCustomerDtoByEmail(email);
    }

    /**
     * Guarda un nuevo cliente en el repositorio.
     *
     * @param newCustomerDto El {@link CustomerDto} que se va a guardar como un nuevo cliente.
     * @return El {@link CustomerDto} que representa al cliente guardado.
     */
    @Override
    public CustomerDto save(CustomerDto newCustomerDto) {
        return iCustomerRepository.save(newCustomerDto);
    }

    @Override
    public PasswordGenerationDto getPasswordGenerationDto(CustomerDto passwordGenerationDto) {
        // Generar nueva contraseña
        String newPassword = generateNewPassword();

        // Validación de nivel servicio para el controlador.
        if (!passwordGenerationDto.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+\\.com)$")) {
            throw new EmailValidationException();
        }

        // Actualizar la contraseña en la base de datos
        CustomerDto existingCustomerDto = iCustomerRepository.getCustomerDtoCarId(passwordGenerationDto.getCardId())
                .orElseThrow(() -> new RuntimeException("Lo sentimos el número de Cliente no coincide con nuestro registro."));

        existingCustomerDto.setPassword(newPassword);
        existingCustomerDto.setActive(1);
        iCustomerRepository.save(existingCustomerDto);

        return new PasswordGenerationDto(newPassword);
    }

    /**
     * Actualiza un cliente existente en el repositorio.
     *
     * @param newCustomerDto El {@link CustomerDto} que representa al cliente actualizado.
     * @return Una instancia de {@link CustomerDto} que representa al cliente actualizado (si existe).
     * Si el cliente no existe, devuelve un Optional vacío.
     */
    @Override
    public Optional<CustomerDto> update(CustomerDto newCustomerDto) {

        if (iCustomerRepository.getCustomerDtoCarId(newCustomerDto.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(newCustomerDto));
    }

    /**
     * Elimina un cliente según su cédula.
     *
     * @param cardId La cédula del cliente a eliminar.
     * @return True si el cliente fue eliminado correctamente, False si el cliente no existe en el repositorio.
     */
    @Override
    public boolean delete(String cardId) {
        if (iCustomerRepository.getCustomerDtoCarId(cardId).isEmpty()) {
            return false;
        }

        iCustomerRepository.delete(cardId);
        return true;
    }

    private String generateNewPassword() {
        // Lógica simple para generar una nueva contraseña (solo para demostración)
        return "NewPassword1234";
    }
}
