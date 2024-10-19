package com.example.week03_web_sale.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Column(name = "note", columnDefinition = "varchar(255)")
    private String note;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private double quantity;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orders;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}