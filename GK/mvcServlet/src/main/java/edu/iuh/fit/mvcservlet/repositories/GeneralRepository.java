package edu.iuh.fit.mvcservlet.repositories;

import edu.iuh.fit.mvcservlet.model.Manufacturer;
import edu.iuh.fit.mvcservlet.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class GeneralRepository<T,ID> {
    private EntityManager entityManager;
    private String entityName;

    public GeneralRepository(String entityName){
        this.entityName = entityName;
        entityManager = Persistence.createEntityManagerFactory("kaiwin").createEntityManager();
    }

    public List<T> findAll() {
        String sql = "from " + entityName;
        List<T> lst = entityManager.createQuery(sql).getResultList();
        return lst;
    }

    public T findByEntity(T entity, ID id) {
        return (T) entityManager.find(entity.getClass(), id);
    }
    public T delete(T entity, ID id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T t =findByEntity(entity,id);
            entityManager.remove(t);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return null;
        }
        return entity;
    }
    public Product save(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return null;
        }
        return product;
    }

    public Manufacturer saveM(Manufacturer manufacturer) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(manufacturer);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return null;
        }
        return manufacturer;
    }
    public T update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return null;
        }
        return entity;
    }


}
