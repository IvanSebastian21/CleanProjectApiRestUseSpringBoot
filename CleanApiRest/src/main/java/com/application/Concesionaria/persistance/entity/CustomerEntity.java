package com.application.Concesionaria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    private String cardId;
    @Column(name = "nombre_completo")
    private String fullName;
    @Column(name = "correo")
    private String email;
    @Column(name = "num_celular")
    private Integer numberCellPhone;
    @Column(name = "activo")
    private Integer active;
    @Column(name = "contrasenia")
    private String password;
}
