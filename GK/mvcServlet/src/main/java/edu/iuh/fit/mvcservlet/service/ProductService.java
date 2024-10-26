package edu.iuh.fit.mvcservlet.service;

import edu.iuh.fit.mvcservlet.model.Product;
import edu.iuh.fit.mvcservlet.repositories.GeneralRepository;

import java.util.List;

public class ProductService {
    private GeneralRepository<Product,Integer> repository;

    public ProductService(){
        repository = new GeneralRepository<>("Product");
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Product product, int id) {
        return repository.findByEntity(product, id);
    }

    public Product deleteProduct(Product product, int id) {
        return repository.delete(product, id);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Product product) {
        return repository.update(product);
    }
}
