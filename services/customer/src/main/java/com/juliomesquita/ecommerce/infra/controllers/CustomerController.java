package com.juliomesquita.ecommerce.infra.controllers;

import com.juliomesquita.ecommerce.infra.dtos.CustomerRequest;
import com.juliomesquita.ecommerce.infra.dtos.CustomerResponse;
import com.juliomesquita.ecommerce.infra.services.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(this.customerService.create(request));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid CustomerRequest request){
        this.customerService.update(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(this.customerService.findAll());
    }

    @GetMapping(value = "/exists/{customer-id}")
    public ResponseEntity<Boolean> findIfExists(@PathVariable("customer-id") String id){
        return ResponseEntity.ok(this.customerService.findIfExist(id));
    }

    @GetMapping(value = "/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String id){
        return ResponseEntity.ok(this.customerService.findById(id));
    }

    @DeleteMapping(value = "/{customer-id}")
    public ResponseEntity<?> delete(@PathVariable("customer-id") String id){
        this.customerService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
