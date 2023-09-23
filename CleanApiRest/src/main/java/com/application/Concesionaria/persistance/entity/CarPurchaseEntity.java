package com.application.Concesionaria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePK id;
    @Column(name = "cantidad")
    private Double quantity;
    @Column(name = "total_precio")
    private Double totalPrice;
    @ManyToOne
    @MapsId(value = "purchaseInvoiceNumber")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;
}
