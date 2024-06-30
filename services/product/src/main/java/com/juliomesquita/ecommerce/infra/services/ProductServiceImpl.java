package com.juliomesquita.ecommerce.infra.services;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.juliomesquita.ecommerce.domain.entities.Category;
import com.juliomesquita.ecommerce.domain.entities.Product;
import com.juliomesquita.ecommerce.infra.dtos.ProductPurchaseRequest;
import com.juliomesquita.ecommerce.infra.dtos.ProductPurchaseResponse;
import com.juliomesquita.ecommerce.infra.dtos.ProductRequest;
import com.juliomesquita.ecommerce.infra.dtos.ProductResponse;
import com.juliomesquita.ecommerce.infra.exceptions.custom.ProductException;
import com.juliomesquita.ecommerce.infra.persistence.ProductRepository;
import com.juliomesquita.ecommerce.infra.persistence.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse create(ProductRequest request) {
        Product entity = this.productRepository.save(this.productMapper.toEntity(request));
        return this.productMapper.toResponse(entity);
    }

    public ProductResponse findById(Integer id) {
        Product entity = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Produto não encontrado."));
        return this.productMapper.toResponse(entity);
    }

    public Boolean findIfExists(Integer id) {
        return this.productRepository.findById(id).isPresent();
    }

    public List<ProductResponse> findAll() {
        return this.productRepository.findAll().stream()
                .map(this.productMapper::toResponse)
                .toList();
    }

    public ProductResponse update(Integer id, ProductRequest request) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Produto não encontrado."));
        Product productToSave = this.mergeToProduct(request, product);
        Product productSaved = this.productRepository.save(productToSave);
        return this.productMapper.toResponse(productSaved);
    }

    public void delete(Integer id) {
        this.productRepository.deleteById(id);
    }

    @Transactional
    public List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        List<Integer> productIds = request.stream().map(ProductPurchaseRequest::productId).toList();
        List<Product> productListSorted = this.productRepository.findAllByIdInOrderById(productIds);
        if (request.size() != productListSorted.size()) {
            throw new ProductException("Um ou mais produtos não foram encontrados.");
        }

        List<ProductPurchaseRequest> requestSorted = request.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId)).toList();
        List<ProductPurchaseResponse> purchaseResponses = new ArrayList<>();
        for (int i = 0; i < productListSorted.size(); i++) {
            Product product = getProduct(productListSorted, i, requestSorted);
            Product productSaved = this.productRepository.save(product);
            purchaseResponses.add(this.productMapper.toProductPurchaseResponse(productSaved));
        }
        return purchaseResponses;
    }

    private static Product getProduct(List<Product> productListSorted, int i, List<ProductPurchaseRequest> requestSorted) {
        Product product = productListSorted.get(i);
        ProductPurchaseRequest productPurchaseRequest = requestSorted.get(i);
        if(product.getAvailableQuantity() < productPurchaseRequest.quantity()){
            throw new ProductException("Quantidade em estoque insuficiente para o produto:: " + productPurchaseRequest.productId());
        }
        double remainingQuantity = product.getAvailableQuantity() - productPurchaseRequest.quantity();
        product.setAvailableQuantity(remainingQuantity);
        return product;
    }

    private Product mergeToProduct(ProductRequest request, Product product) {
        return Product
                .builder()
                .id(product.getId())
                .name(request.name() != null ? request.name() : product.getName())
                .description(request.description() != null ? request.description() : product.getDescription())
                .availableQuantity(request.availableQuantity() != null ? request.availableQuantity() : product.getAvailableQuantity())
                .price(request.price() != null ? request.price() : product.getPrice())
                .category(Category.builder().id(request.categoryId() != null ? request.categoryId() : product.getCategory().getId()).build())
                .build();
    }
}