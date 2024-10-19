package com.example.frontend.controllers;

import com.example.backend.repositories.entities.Product;
import com.example.frontend.models.ProductModel;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers", value = "/controllers")
public class Controllers extends HttpServlet {
    @Inject
    private ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            String name = req.getParameter("name");
            String desc = req.getParameter("desc");
            String imgPath = req.getParameter("imgPath");
            productModel.createProduct(new Product(name, desc, imgPath));
//            resp.sendRedirect("ListProduct.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
