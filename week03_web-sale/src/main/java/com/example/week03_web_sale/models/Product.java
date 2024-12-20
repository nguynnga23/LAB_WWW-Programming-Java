package com.example.week03_web_sale.models;

import com.example.week03_web_sale.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "unit", columnDefinition = "varchar(25)")
    private String unit;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @Column(name = "manufacturer_name", columnDefinition = "varchar(100)")
    private String manufacturer;
    @Column(name = "name", columnDefinition = "varchar(150)")
    private String name;
    @Column(name = "description", columnDefinition = "varchar(250)")
    private String description;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    List<ProductPrice> productPrices;
}