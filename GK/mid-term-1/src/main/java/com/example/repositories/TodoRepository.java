package com.example.repositories;

import com.example.entities.Todo;
import com.example.services.TodoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class TodoRepository implements TodoService {
    private EntityManager em;
    public TodoRepository() {
        em = Persistence.createEntityManagerFactory("midterm1").createEntityManager();
    }

    @Override
    public boolean insertTodo(Todo todo) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(todo);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            return false;
        }
    }

    @Override
    public Todo selectTodo(int id) {
        return em.find(Todo.class, id);
    }

    @Override
    public List<Todo> selectAllTodos() {
        return em.createNamedQuery("Todo.selectAllTodos", Todo.class).getResultList();
    }

    @Override
    public boolean updateTodo(Todo todo) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(todo);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteTodo(int id) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Todo todo = em.find(Todo.class, id);
            em.remove(todo);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            return false;
        }
    }

    public static void main(String[] args) {
        TodoRepository repo = new TodoRepository();
        repo.deleteTodo(4);

    }
}
