package com.juliomesquita.ecommerce.infra.persistence.mapper;

import com.juliomesquita.ecommerce.domain.entities.OrderLine;
import com.juliomesquita.ecommerce.domain.entities.PurchaseOrder;
import com.juliomesquita.ecommerce.infra.dtos.OrderLineRequest;
import com.juliomesquita.ecommerce.infra.dtos.OrderLineResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {
    public OrderLine toEntity(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .productId(request.productId())
                .purchaseOrder(PurchaseOrder.builder().id(request.orderId()).build())
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toResponse(OrderLine entity) {
        return new OrderLineResponse(
                entity.getId(), entity.getQuantity());
    }
}
