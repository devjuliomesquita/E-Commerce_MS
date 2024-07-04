package com.juliomesquita.ecommerce.infra.communication_between_services.product;

import com.juliomesquita.ecommerce.infra.dtos.PurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        name = "product-ms",
        url = "${application.config.product-url}"
)
public interface ProductClient {
    @PostMapping(value = "/purchase")
    List<PurchaseResponse> purchase(List<PurchaseRequest> request);
}
