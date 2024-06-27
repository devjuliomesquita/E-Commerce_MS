package com.juliomesquita.ecommerce.infra.services;

import com.juliomesquita.ecommerce.domain.entities.Customer;
import com.juliomesquita.ecommerce.infra.dtos.CustomerRequest;
import com.juliomesquita.ecommerce.infra.dtos.CustomerResponse;
import com.juliomesquita.ecommerce.infra.exceptions.custom.CustomerNotFoundException;
import com.juliomesquita.ecommerce.infra.persistence.CustomerRepository;
import com.juliomesquita.ecommerce.infra.persistence.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String create(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return null;
        }
        Customer customer = this.customerRepository.save(this.customerMapper.toEntity(customerRequest));
        return customer.getId();
    }

    public void update(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return;
        }
        Customer customer = this.customerRepository.findById(customerRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado."));

        Customer customerUpdated = this.mergeCustomer(customer, customerRequest);
        this.customerRepository.save(customerUpdated);
    }

    public CustomerResponse findById(String id) {
        return this.customerRepository.findById(id)
                .map(this.customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado."));
    }

    public Boolean findIfExist(String id) {
        return this.customerRepository.findById(id).isPresent();
    }

    public List<CustomerResponse> findAll() {
        return this.customerRepository.findAll()
                .stream()
                .map(this.customerMapper::toDto)
                .toList();
    }

    public void delete(String id) {
        this.customerRepository.deleteById(id);
    }

    private Customer mergeCustomer(Customer customer, CustomerRequest request) {
        return Customer.builder()
                .id(customer.getId())
                .email(request.email() != null ? request.email() : customer.getEmail())
                .firstName(request.firstName() != null ? request.firstName() : customer.getFirstName())
                .lastName(request.lastName() != null ? request.lastName() : customer.getLastName())
                .address(request.address() != null ? request.address() : customer.getAddress())
                .build();
    }


}
