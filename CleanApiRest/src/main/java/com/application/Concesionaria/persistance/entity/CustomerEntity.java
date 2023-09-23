package com.application.Concesionaria.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase que representa la entidad de cliente en la base de datos.
 *
 * Esta entidad mapea la tabla "cliente" en la base de datos y define los campos correspondientes.
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {
    @Id
    @Column(name = "cedula")
    @NotEmpty
    @NotBlank
    @Size(min = 4)
    private String cardId;

    @NotBlank
    @NotEmpty()
    @Size(min = 4)
    @Column(name = "nombre_completo")
    private String fullName;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+\\.com)$")
    @Email()
    @NotEmpty()
    @Column(name = "correo")
    private String email;

    @NotNull
    @Column(name = "num_celular")
    private Integer numberCellPhone;

    @NotNull
    @Column(name = "activo")
    private Integer active;
    @Column(name = "contrasenia")
    private String password;

    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntityList;
}
