package com.juliomesquita.ecommerce.infra.dtos;

import com.juliomesquita.ecommerce.domain.entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "E-mail é necessário")
        @Email(message = "E-mail inválido.")
        String email,
        @NotNull(message = "Nome não pode ser nulo.")
        String firstName,
        @NotNull(message = "Sobrenome não pode ser nulo.")
        String lastName,
        Address address
) {
}
