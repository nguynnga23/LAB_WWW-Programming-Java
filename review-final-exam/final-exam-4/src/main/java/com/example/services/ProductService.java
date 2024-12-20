package com.example.services;

import com.example.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void update(Product product, Long id);
    void delete(Long id);
    Product findById(Long id);
    Page<Product> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);
    List<Product> search(String keyword, int pageNo, int pageSize, String sortBy, String sortDirection);
    List<Product> findByCategory(Long categoryId);
}
