package com.application.Concesionaria.persistance.mapper;

import com.application.Concesionaria.domain.dto.PurchaseDtoRequest;
import com.application.Concesionaria.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseDtoRequest toPurchaseDtoRequest(PurchaseEntity purchaseEntity);

//    @Mapping(target = "invoiceNumber", source = "invoiceNumber")
//    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseDtoRequest purchaseDtoRequest);
    List<PurchaseDtoRequest> toPurchaseDtoRequestList(List<PurchaseEntity> purchaseEntityList);
}
