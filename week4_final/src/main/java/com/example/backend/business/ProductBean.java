package com.example.backend.business;

import com.example.backend.repositories.entities.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;

import java.util.List;
@Stateless
public class ProductBean implements ProductBeanRemote {

    @PersistenceContext(unitName = "lab_week_4")
    EntityManager em;

    @Override
    @Consumes("application/json")
    @Produces("application/json")
    public void add(Product product) {
        try {
            em.persist(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return (Product) em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
    }

}
