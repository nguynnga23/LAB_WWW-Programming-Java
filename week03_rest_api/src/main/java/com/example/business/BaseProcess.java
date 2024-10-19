package com.example.business;

import com.example.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class BaseProcess {

    @PersistenceContext(unitName = "mypu")
    private EntityManager entityManager;

    public List<Student> getAll(){
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    public Student getById(long id){
        TypedQuery<Student> q = entityManager.createQuery("select s from Student s where s.id=:id", Student.class);
        q.setParameter("id",id);
        return q.getSingleResult();
    }

    public Student persist(Student student){
        entityManager.persist(student);
        return student;
    }

}
