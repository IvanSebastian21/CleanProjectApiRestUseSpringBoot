package com.application.Concesionaria.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CarPurchasePK implements Serializable {

    @Serial
    private static final long serialVersionUID = -2353262627524321612L;
    @Column(name = "compras_numero_factura")
    private Integer purchaseInvoiceNumber;
    @Column(name = "coches_codigo_coche")
    private Integer carCode;
}
