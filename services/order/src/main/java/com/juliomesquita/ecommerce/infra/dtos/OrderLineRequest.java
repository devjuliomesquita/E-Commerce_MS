package com.juliomesquita.ecommerce.infra.dtos;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity
) {
}
