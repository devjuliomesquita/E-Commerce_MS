package com.juliomesquita.ecommerce.infra.exceptions.dto;

import java.util.Map;

public record CustomErrorResponse(
        Map<String, String> errors
) {
}
