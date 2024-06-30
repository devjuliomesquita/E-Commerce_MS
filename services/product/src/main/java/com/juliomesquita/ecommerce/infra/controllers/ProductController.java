package com.juliomesquita.ecommerce.infra.controllers;

import com.juliomesquita.ecommerce.infra.dtos.ProductPurchaseRequest;
import com.juliomesquita.ecommerce.infra.dtos.ProductPurchaseResponse;
import com.juliomesquita.ecommerce.infra.dtos.ProductRequest;
import com.juliomesquita.ecommerce.infra.dtos.ProductResponse;
import com.juliomesquita.ecommerce.infra.services.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(this.productService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping(value = "/exists/{product-id}")
    public ResponseEntity<Boolean> findIfExists(@PathVariable("product-id") Integer id) {
        return ResponseEntity.ok(this.productService.findIfExists(id));
    }

    @GetMapping(value = "/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @PutMapping(value = "/{product-id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable(value = "product-id") Integer id,
            @RequestBody @Valid ProductRequest request
    ) {
        ProductResponse response = this.productService.update(id, request);
        return ResponseEntity.accepted().body(response);
    }

    @DeleteMapping(value = "/{product-id}")
    public ResponseEntity<?> delete(@PathVariable("product-id") Integer id) {
        this.productService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
            @RequestBody @Valid List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(this.productService.purchaseProducts(request));
    }

}
