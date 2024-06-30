package com.juliomesquita.ecommerce.infra.dtos;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}
