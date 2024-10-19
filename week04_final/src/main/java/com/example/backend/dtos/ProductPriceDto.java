package com.example.backend.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.example.backend.repositories.entities.ProductPrice}
 */
public class ProductPriceDto implements Serializable {
    private final Integer id;
    private final ProductDto product;
    @NotNull
    private final Integer productId;
    @NotNull
    private final Instant applyDate;
    @NotNull
    private final Double value;
    private final String note;

    public ProductPriceDto(Integer id, ProductDto product, Integer productId, Instant applyDate, Double value, String note) {
        this.id = id;
        this.product = product;
        this.productId = productId;
        this.applyDate = applyDate;
        this.value = value;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public Integer getProductId() {
        return productId;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public Double getValue() {
        return value;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPriceDto entity = (ProductPriceDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.product, entity.product) &&
                Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.applyDate, entity.applyDate) &&
                Objects.equals(this.value, entity.value) &&
                Objects.equals(this.note, entity.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, productId, applyDate, value, note);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "product = " + product + ", " +
                "productId = " + productId + ", " +
                "applyDate = " + applyDate + ", " +
                "value = " + value + ", " +
                "note = " + note + ")";
    }
}