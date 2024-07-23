package com.juliomesquita.ecommerce.infra.services;

import com.juliomesquita.ecommerce.domain.entities.OrderLine;
import com.juliomesquita.ecommerce.infra.dtos.OrderLineRequest;
import com.juliomesquita.ecommerce.infra.persistence.interfaces.OrderLineRepository;
import com.juliomesquita.ecommerce.infra.persistence.mapper.OrderLineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public Integer create(OrderLineRequest request){
        OrderLine entity = this.orderLineMapper.toEntity(request);
        return this.orderLineRepository.save(entity).getId();
    }
}
