package backend.business;

import com.example.backend.repositories.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    public void add(Product product);
    public List<Product> findAll();
    public Product findById(int id);
}
