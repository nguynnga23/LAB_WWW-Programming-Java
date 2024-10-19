package com.example.week03_web_sale;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class test {
    public static void main(String[] args) {
        // Tạo một phiên Hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_week_2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            System.out.println("Done!!");
            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
