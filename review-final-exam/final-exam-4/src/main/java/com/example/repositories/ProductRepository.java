package com.example.repositories;

import com.example.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "CAST(p.price AS string) LIKE CONCAT('%', :keyword, '%') OR " +
            "CAST(p.registerDate AS string) LIKE CONCAT('%', :keyword, '%')")
    List<Product> searchProducts(@Param("keyword") String keyword, Pageable pageable);
    List<Product> findProductsByCategory_Id(Long categoryId);
}
