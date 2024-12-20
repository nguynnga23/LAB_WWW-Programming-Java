package com.example.controllers;


import com.example.dtos.UserLoginDTO;
import com.example.entities.Todo;
import com.example.entities.User;
import com.example.repositories.TodoRepository;
import com.example.repositories.UserRepository;
import com.example.services.TodoService;
import com.example.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "todos", value = "/todos")
public class TodoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoService todoService;

    public void init() {
        todoService = new TodoRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            switch (action) {
                case "new":
                    showNewForm(req, resp);
                    break;
                case "insert":
                    insertTodo(req, resp);
                    break;
                case "delete":
                    deleteTodo(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "update":
                    updateTodo(req, resp);
                    break;
                case "list":
                    listTodos(req, resp);
                    break;
                default:
                    RequestDispatcher dispatcher = req.getRequestDispatcher("login-form.jsp");
                    dispatcher.forward(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void listTodos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Todo> listTodo = todoService.selectAllTodos();
        req.setAttribute("listTodo", listTodo);
        RequestDispatcher view = req.getRequestDispatcher("todo-list.jsp");
        view.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("todo-form.jsp");
        view.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Todo existedTodo = todoService.selectTodo(id);
        RequestDispatcher view = req.getRequestDispatcher("todo-form.jsp");
        req.setAttribute("todo", existedTodo);
        view.forward(req, resp);
    }

    private void insertTodo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String username = req.getParameter("username");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate targetDate = LocalDate.parse(req.getParameter("targetDate"), df);
        boolean isDone = Boolean.parseBoolean(req.getParameter("isDone"));
        Todo newTodo = new Todo();
        newTodo.setTitle(title);
        newTodo.setDescription(description);
        newTodo.setUsername(username);
        newTodo.setTargetDate(targetDate);
        newTodo.setIsDone(isDone);
        todoService.insertTodo(newTodo);
        resp.sendRedirect("list");
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String description = request.getParameter("description");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));

        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        Todo updateTodo = new Todo(id, description, isDone, targetDate, username, title);

        todoService.updateTodo(updateTodo);
        response.sendRedirect("list");
    }

    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        todoService.deleteTodo(id);
        response.sendRedirect("todos?action=list");
    }
}
