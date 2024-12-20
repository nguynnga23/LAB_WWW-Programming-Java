package com.example.services.impl;

import com.example.models.Product;
import com.example.repositories.ProductRepository;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void update(Product product, Long id) {
        if (this.productRepository.findById(id).isPresent()) {
            this.productRepository.save(product);
        }
    }

    @Override
    public void delete(Long id) {
        if (this.productRepository.findById(id).isPresent()) {
            this.productRepository.deleteById(id);
        }
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> search(String keyword, int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return productRepository.searchProducts(keyword, pageable);
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        return productRepository.findProductsByCategory_Id(categoryId);
    }
}
