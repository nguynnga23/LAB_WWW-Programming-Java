package com.example.week03_web_sale.repositories;

import com.example.week03_web_sale.enums.EmployeeStatus;
import com.example.week03_web_sale.models.Employee;
import jakarta.persistence.*;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository() {
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans = em.getTransaction();
    }
    public void insertEmployee(Employee emp) {
        try {
            trans.begin();
            em.persist(emp);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
//            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
//        employee.setStatus(status);
    }

    public void update(Employee emp) {
        try {
            trans.begin();
            em.merge(emp);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
//            ex.printStackTrace();
        }
    }

    public Optional<Employee> findById(long id) {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return em == null ? Optional.empty() : Optional.of(emp);
    }

    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
