package com.example.backend.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.backend.repositories.entities.Product}
 */
public class ProductDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 150)
    private final String name;
    @NotNull
    private final String description;
    @Size(max = 250)
    private final String imgPath;

    public ProductDto(Integer id, String name, String description, String imgPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgPath() {
        return imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.imgPath, entity.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imgPath);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "imgPath = " + imgPath + ")";
    }
}