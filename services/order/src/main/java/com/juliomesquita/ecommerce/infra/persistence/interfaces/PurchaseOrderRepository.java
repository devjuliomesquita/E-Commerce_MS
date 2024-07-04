package com.juliomesquita.ecommerce.infra.persistence.interfaces;

import com.juliomesquita.ecommerce.domain.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
}
