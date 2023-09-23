package com.application.Concesionaria.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDtoRequest {
    private Integer invoiceNumber;
    private String customerId;
    private LocalDateTime purchaseDate;
    private Double totalAmount;
    private String paymentMethod;
    private List<CarPurchaseDtoRequest> carPurchaseDtoRequestList;
}
