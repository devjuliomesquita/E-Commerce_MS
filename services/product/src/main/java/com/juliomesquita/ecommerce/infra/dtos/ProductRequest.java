package com.juliomesquita.ecommerce.infra.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotNull(message = "Nome é necessário")
        String name,
        @NotNull(message = "Descrição é necessário")
        String description,
        @Positive(message = "A quantidade disponivel precisa ser maior que zero.")
        Double availableQuantity,
        @Positive(message = "O valor do produto precisa ser maior que zero.")
        BigDecimal price,
        @NotNull(message = "Um Id de categoria é necessário")
        Integer categoryId
) {
}
