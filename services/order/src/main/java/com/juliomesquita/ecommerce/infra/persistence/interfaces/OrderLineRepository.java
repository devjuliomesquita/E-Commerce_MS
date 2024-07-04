package com.juliomesquita.ecommerce.infra.persistence.interfaces;

import com.juliomesquita.ecommerce.domain.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
