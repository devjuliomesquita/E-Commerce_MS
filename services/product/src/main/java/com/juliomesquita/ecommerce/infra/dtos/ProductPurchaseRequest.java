package com.juliomesquita.ecommerce.infra.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "O Id do produto não pode ser nulo.")
        Integer productId,
        @Positive(message = "A quantidade deve ser maior que 0.")
        Double quantity
) {
}
