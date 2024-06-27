package com.juliomesquita.ecommerce.infra.persistence.mapper;

import com.juliomesquita.ecommerce.domain.entities.Address;
import com.juliomesquita.ecommerce.domain.entities.Customer;
import com.juliomesquita.ecommerce.infra.dtos.CustomerRequest;
import com.juliomesquita.ecommerce.infra.dtos.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequest customerRequest) {
        return Customer.builder()
                .id(customerRequest.id())
                .email(customerRequest.email())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .address(customerRequest.address())
                .build();
    }

    public CustomerResponse toDto(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .build();
    }

}
