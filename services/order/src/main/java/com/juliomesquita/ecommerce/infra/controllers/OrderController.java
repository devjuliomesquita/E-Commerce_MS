package com.juliomesquita.ecommerce.infra.controllers;

import com.juliomesquita.ecommerce.infra.dtos.OrderRequest;
import com.juliomesquita.ecommerce.infra.services.PurchaseOrderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final PurchaseOrderServiceImpl purchaseOrderService;

    public ResponseEntity<Integer> create(@RequestBody @Valid OrderRequest request){
        return ResponseEntity.ok(this.purchaseOrderService.create(request));
    }
}
