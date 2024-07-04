package com.juliomesquita.ecommerce.infra.dtos;

import com.juliomesquita.ecommerce.domain.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "O montante deve ser maior que zero.")
        BigDecimal amount,
        @NotNull(message = "O método de pagamento é obrigatório.")
        PaymentMethod paymentMethod,
        @NotNull(message = "O id do cliente é obrigatório.")
        @NotEmpty(message = "O id do cliente é obrigatório.")
        @NotBlank(message = "O id do cliente é obrigatório.")
        String customerId,
        @NotEmpty(message = "A lista precisa ter produtos.")
        List<PurchaseRequest> products
) {
}
