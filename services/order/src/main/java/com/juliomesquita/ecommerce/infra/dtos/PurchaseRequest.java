package com.juliomesquita.ecommerce.infra.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record PurchaseRequest(
        @NotNull(message = "O id do produto é obrigatório.")
        Integer productId,
        @Positive(message = "Quantidade deve ser maior que zero.")
        Double quantity
) {
}
