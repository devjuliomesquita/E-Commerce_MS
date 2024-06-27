package com.juliomesquita.ecommerce.infra.dtos;

import com.juliomesquita.ecommerce.domain.entities.Address;
import lombok.Builder;

@Builder
public record CustomerResponse(
        String id,
        String email,
        String firstName,
        String lastName,
        Address address
) {
}
