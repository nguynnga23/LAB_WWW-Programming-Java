package edu.iuh.fit.mvcservlet.controller;

import edu.iuh.fit.mvcservlet.model.Manufacturer;
import edu.iuh.fit.mvcservlet.model.Product;
import edu.iuh.fit.mvcservlet.service.ManufactureService;
import edu.iuh.fit.mvcservlet.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@WebServlet(urlPatterns = {"/product"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductService();
        ManufactureService manufactureService = new ManufactureService();
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch(action){
            case "danh-sach-product":
            {
                session.setAttribute("products",service.findAll());
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
                break;
            case "add-product":
            {
                List<Manufacturer> manufacturers = manufactureService.findAll();
                session.setAttribute("manufactures",manufacturers);
                req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
            }
                break;
            case "update":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                Product product = service.findById(new Product(),id);
                req.setAttribute("product",product);
                List<Manufacturer> manufacturers = manufactureService.findAll();
                session.setAttribute("manufactures",manufacturers);
                req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
            }
                break;
            case "delete":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                Product product = service.findById(new Product(),id);
                service.deleteProduct(product,id);
                resp.sendRedirect("product?action=danh-sach-product");
            }
                break;
            default:
                req.getRequestDispatcher("home.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        ManufactureService manufactureService = new ManufactureService();
        ProductService productService = new ProductService();
        switch (action){
            case "add-product":
            {
                String regexNumber = "^[0-9]+$";
                boolean checkValue = false;
                String name = "";
                double price=0;
                String description = req.getParameter("description");
                String nameManufactuer = req.getParameter("manufacture");
                Manufacturer manufacturer = new Manufacturer();
                for (Manufacturer mn:manufactureService.findAll()){
                    if(mn.getName().equals(nameManufactuer)){
                        manufacturer = mn;
                    }
                }
//                validator value
                if(req.getParameter("price").isEmpty()){
                    req.setAttribute("errorPrice","price is not empty!");
                    checkValue = false;
                } else if (!req.getParameter("price").matches(regexNumber)) {
                    req.setAttribute("errorPrice","price is not number!");
                    checkValue = false;
                } else if(req.getParameter("name").isEmpty()){
                    req.setAttribute("errorPrice","name is not empty!");
                    checkValue = false;
                }else {
                    checkValue = true;
                    price =Double.parseDouble(req.getParameter("price"));
                    name = req.getParameter("name");
                }
//                check validator
                if (checkValue == false){
                    req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
                }else {
                    Product product = new Product(name,price,description);
                    product.setManid(manufacturer);
                    productService.save(product);
                    List<Manufacturer> manufacturers = manufactureService.findAll();
                    session.setAttribute("manufactures",manufacturers);
                    resp.sendRedirect("product?action=danh-sach-product");
                }
            }
                break;
            case "update":
            {
                String regexNumber = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";
                boolean checkValue = false;
                int id = Integer.parseInt(req.getParameter("id"));
                String name = "";
                double price=0;
                String description = req.getParameter("description");
                String nameManufactuer = req.getParameter("manufacture");
                Manufacturer manufacturer = new Manufacturer();
                for (Manufacturer mn:manufactureService.findAll()){
                    if(mn.getName().equals(nameManufactuer)){
                        manufacturer = mn;
                    }
                }
//                validator value
                if(req.getParameter("price").isEmpty()){
                    req.setAttribute("errorPrice","price is not empty!");
                    checkValue = false;
                } else if (!req.getParameter("price").matches(regexNumber)) {
                    req.setAttribute("errorPrice","price is not number!");
                    checkValue = false;
                } else if(req.getParameter("name").isEmpty()){
                    req.setAttribute("errorPrice","name is not empty!");
                    checkValue = false;
                }else {
                    checkValue = true;
                    price =Double.parseDouble(req.getParameter("price"));
                    name = req.getParameter("name");
                }
//                check validator
                if (checkValue == false){

                    Product product = productService.findById(new Product(),id);
                    req.setAttribute("product",product);
                    req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
                }else {
                    Product product = new Product(name,price,description);
                    product.setId(id);
                    product.setManid(manufacturer);
                    productService.update(product);
                    resp.sendRedirect("product?action=danh-sach-product");
                }
            }
                break;
            default:
                break;
        }
    }
}
