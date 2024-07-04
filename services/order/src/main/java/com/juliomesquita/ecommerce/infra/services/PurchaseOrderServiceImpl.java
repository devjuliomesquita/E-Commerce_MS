package com.juliomesquita.ecommerce.infra.services;

import com.juliomesquita.ecommerce.domain.entities.PurchaseOrder;
import com.juliomesquita.ecommerce.infra.communication_between_services.customer.CustomerClient;
import com.juliomesquita.ecommerce.infra.communication_between_services.customer.CustomerResponse;
import com.juliomesquita.ecommerce.infra.communication_between_services.product.ProductClient;
import com.juliomesquita.ecommerce.infra.communication_between_services.product.PurchaseResponse;
import com.juliomesquita.ecommerce.infra.dtos.OrderRequest;
import com.juliomesquita.ecommerce.infra.exceptions.custom.CommunicationBetweenServicesException;
import com.juliomesquita.ecommerce.infra.persistence.interfaces.PurchaseOrderRepository;
import com.juliomesquita.ecommerce.infra.persistence.mapper.PurchaseOrderMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl {
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Transactional
    public Integer create(OrderRequest request){
        CustomerResponse customerResponse = this.customerClient.findById(request.customerId())
                .orElseThrow(() -> new CommunicationBetweenServicesException("Usuário não encontrado."));

        List<PurchaseResponse> purchaseResponses = this.productClient.purchase(request.products());
        if(purchaseResponses.isEmpty()) { throw new CommunicationBetweenServicesException("Erro ao processar os produtos.");}

        PurchaseOrder purchaseOrder = this.purchaseOrderRepository.save(this.purchaseOrderMapper.toEntity(request));

        /*
        * Criar o serviço de criação de Order Line
        * payment
        * notification
        * */

        return null;
    }


}
