package com.example.controllers;

import com.example.dtos.UserLoginDTO;
import com.example.entities.User;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "users", value = "/users")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public void init() {
        userService = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        switch (action) {
            case "register": {
                register(req, resp);
            }
            break;
            case "login": {
                try {
                    authentication(req, resp);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstName);
        user.setLastname(lastName);

        try {
            Boolean result = userService.register(user);
            if (result) {
                req.setAttribute("message", "User registered successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("register-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void authentication(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserLoginDTO userLoginDTO = new UserLoginDTO(username, password);
        if (userService.login(userLoginDTO)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("todo-list.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession();
        }

    }
}
