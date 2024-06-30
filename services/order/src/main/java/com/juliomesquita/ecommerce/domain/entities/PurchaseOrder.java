package com.juliomesquita.ecommerce.domain.entities;

import com.juliomesquita.ecommerce.domain.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id")
    private Integer id;

    @Column(name = "purchase_order_reference", unique = true)
    private String reference;

    @Column(name = "purchase_order_total_amount")
    private BigDecimal totalAmount;

    @Column(name = "purchase_order_costumer_id")
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "purchase_order_payment_method")
    private PaymentMethod paymentMethod;

    @CreatedDate
    @Column(name = "purchase_order_created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "purchase_order_modify_at")
    private LocalDateTime modifyAt;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
}
