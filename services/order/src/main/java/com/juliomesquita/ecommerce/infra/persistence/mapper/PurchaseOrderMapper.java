package com.juliomesquita.ecommerce.infra.persistence.mapper;

import com.juliomesquita.ecommerce.domain.entities.PurchaseOrder;
import com.juliomesquita.ecommerce.infra.dtos.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper {

    public PurchaseOrder toEntity(OrderRequest request) {
        if (request == null) {
            return null;
        }
        return PurchaseOrder.builder()
                .id(request.id())
                .reference(request.reference())
                .totalAmount(request.amount())
                .customerId(request.customerId())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
