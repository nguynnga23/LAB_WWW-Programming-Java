package com.example.services;

import com.example.entities.Todo;
import java.util.List;
public interface TodoService {
    public boolean insertTodo(Todo todo);
    public Todo selectTodo(int id);
    public List<Todo> selectAllTodos();
    public boolean updateTodo(Todo todo);
    public boolean deleteTodo(int id);
}
