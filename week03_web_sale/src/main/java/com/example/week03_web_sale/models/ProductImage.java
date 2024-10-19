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
@Table(name = "product_image")
public class ProductImage {
    @Id
    @Column(name = "image_id", columnDefinition = "varchar(255)")
    private Long imageId;
    @Column(name = "alternative", columnDefinition = "varchar(250)")
    private String alternative;
    @Column(name = "path", columnDefinition = "varchar(250)")
    private String path;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}