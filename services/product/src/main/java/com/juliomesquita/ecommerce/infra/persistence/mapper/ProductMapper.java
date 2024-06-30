package com.juliomesquita.ecommerce.infra.persistence.mapper;

import com.juliomesquita.ecommerce.domain.entities.Category;
import com.juliomesquita.ecommerce.domain.entities.Product;
import com.juliomesquita.ecommerce.infra.dtos.ProductPurchaseResponse;
import com.juliomesquita.ecommerce.infra.dtos.ProductRequest;
import com.juliomesquita.ecommerce.infra.dtos.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest request) {
        return Product
                .builder()
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(Category.builder().id(request.categoryId()).build())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product) {
        return ProductPurchaseResponse
                .builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getAvailableQuantity())
                .build();
    }
}
