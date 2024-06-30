package com.juliomesquita.ecommerce.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_available_quantity")
    private Double availableQuantity;

    @Column(name = "product_price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id")
    private Category category;
}
