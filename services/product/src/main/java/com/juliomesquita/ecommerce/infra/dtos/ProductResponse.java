package com.juliomesquita.ecommerce.infra.dtos;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        Integer id,
        String name,
        String description,
        Double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
