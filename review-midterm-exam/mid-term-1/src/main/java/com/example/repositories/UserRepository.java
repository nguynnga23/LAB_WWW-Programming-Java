package com.example.repositories;

import com.example.dtos.UserLoginDTO;
import com.example.entities.User;
import com.example.services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class UserRepository implements UserService {
    private EntityManager em;

    public UserRepository() {
        em = Persistence.createEntityManagerFactory("midterm1").createEntityManager();
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        try {
            em.createQuery("select user from User user where user.username=:username and user.password=:password", User.class)
                    .setParameter("username", userLoginDTO.getUsername())
                    .setParameter("password", userLoginDTO.getPassword())
                    .getSingleResult();
            return true; // Đăng nhập thành công
        } catch (NoResultException e) {
            return false; // Đăng nhập thất bại
        }
    }

    @Override
    public boolean register(User user) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public User selectUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public boolean updateUser(User user) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        return em.createNamedQuery("User.deleteUser", User.class).setParameter("id", id).executeUpdate() > 0;
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstname("Kien");
        user.setLastname("Nguyen");
        user.setUsername("Kien");
        user.setPassword("123");
        System.out.println(userRepository.register(user));
    }
}
