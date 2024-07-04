package com.juliomesquita.ecommerce.infra.communication_between_services.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
