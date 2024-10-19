package com.example.week03_web_sale.repositories;

import com.example.week03_web_sale.enums.EmployeeStatus;
import com.example.week03_web_sale.models.Employee;
import jakarta.persistence.*;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class EmployeeRepository {
   @PersistenceContext(unitName = "myweb")
   private EntityManager em;

    public EmployeeRepository() {
    }
    public void insertEmployee(Employee emp) {
        try {
            em.persist(emp);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public void update(Employee emp) {
        try {
            em.merge(emp);
        }catch (Exception ex){
            ex.printStackTrace();
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
