package com.example.backend.business;

import com.example.backend.repositories.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    public void add(Product product);
    public List<Product> findAll();
    public Product findById(int id);
    public Boolean deleteById(int id);
    public Product update(Product product);
}
