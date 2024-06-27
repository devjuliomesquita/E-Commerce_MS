package com.juliomesquita.ecommerce.infra.persistence;

import com.juliomesquita.ecommerce.domain.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
