package com.juliomesquita.ecommerce.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Integer id;

    @Column(name = "order_line_product_id")
    private Integer productId;

    @Column(name = "order_line_quantity")
    private Double quantity;

    @ManyToOne()
    @JoinColumn(name = "order_line_purchase_order_id", referencedColumnName = "purchase_order_id")
    private PurchaseOrder purchaseOrder;
}
