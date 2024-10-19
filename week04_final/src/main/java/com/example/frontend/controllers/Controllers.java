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
import java.util.List;

@WebServlet(name = "controllers", value = "/controllers")
public class Controllers extends HttpServlet {
    @Inject
    private ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":

                String name = req.getParameter("name");
                String desc = req.getParameter("desc");
                String imgPath = req.getParameter("imgPath");
                productModel.createProduct(new Product(name, desc, imgPath));
                break;

            case "list":
                List<Product> products = productModel.getAllProducts();
                req.setAttribute("products", products);
                req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);

            case "delete":
                int id1 = Integer.parseInt(req.getParameter("id"));
                productModel.deleteProductById(id1);
                resp.sendRedirect("list");
                break;
            case "edit":
                int id2 = Integer.parseInt(req.getParameter("id"));
                String nameUpdate = req.getParameter("name");
                String descUpdate = req.getParameter("desc");
                String imgPathUpdate = req.getParameter("imgPath");

                Product productUpdate = new Product(nameUpdate, descUpdate, imgPathUpdate);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
