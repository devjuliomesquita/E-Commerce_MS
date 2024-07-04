package com.juliomesquita.ecommerce.infra.communication_between_services.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-ms",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping(value = "/{customer-id}")
    Optional<CustomerResponse> findById(@PathVariable(value = "customer-id") String id);
}
