package edu.iuh.fit.mvcservlet.controller;


import edu.iuh.fit.mvcservlet.model.Manufacturer;
import edu.iuh.fit.mvcservlet.service.ManufactureService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/manager"})
public class ManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManufactureService manufactureService = new ManufactureService();
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch(action){
            case "danh-sach-manu":
            {
                session.setAttribute("managers",manufactureService.findAll());
                req.getRequestDispatcher("manager.jsp").forward(req, resp);
            }
            break;

            case "add-manager":
            {
                List<Manufacturer> manufacturers = manufactureService.findAll();
                session.setAttribute("manufactures",manufacturers);
                req.getRequestDispatcher("addManager.jsp").forward(req, resp);
            }
            break;
            case "update":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                Manufacturer manager = manufactureService.findById(new Manufacturer(),id);
                req.setAttribute("managers",manager);
                req.getRequestDispatcher("addManager.jsp").forward(req, resp);
            }
            break;
            case "delete":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                Manufacturer manufacturer = manufactureService.findById(new Manufacturer(),id);
                manufactureService.deleteManu(manufacturer,id);
                resp.sendRedirect("manager?action=danh-sach-manu");
            }
            break;

            default:
                req.getRequestDispatcher("manager.jsp").forward(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        ManufactureService manufactureService = new ManufactureService();
        switch (action){
            case "add-manager":
            {
                String regexNumber = "^[0-9]+$";
                boolean checkValue = false;
                String name = "";
                int id=-1;

//                validator value
                if(req.getParameter("id").isEmpty()){
                    req.setAttribute("error IDD","ID  is not empty!");
                    checkValue = false;
                } else if (!req.getParameter("id").matches(regexNumber)) {
                    req.setAttribute("error ID","ID is not number!");
                    checkValue = false;
                } else if(req.getParameter("name").isEmpty()){
                    req.setAttribute("error Nameee ","name is not empty!");
                    checkValue = false;
                }else {
                    checkValue = true;
                    id =Integer.parseInt(req.getParameter("id"));
                    name = req.getParameter("name");
                }
//                check validator
                if (checkValue == false){
                    req.getRequestDispatcher("addManager.jsp").forward(req, resp);
                }else {
                    Manufacturer manufacturer = new Manufacturer(id, name);

                    manufactureService.saveM(manufacturer);
                    List<Manufacturer> manufacturers = manufactureService.findAll();
                    session.setAttribute("manufactures",manufacturers);
                    resp.sendRedirect("manager?action=danh-sach-manu");
                }
            }
                break;

            case "update":
            {
                String regexNumber = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";
                boolean checkValue = false;
                int id = Integer.parseInt(req.getParameter("id"));
                String name = "";
//                validator value
                 if(req.getParameter("name").isEmpty()){
                    req.setAttribute("error on Name","name is not empty!");
                    checkValue = false;
                }else {
                    checkValue = true;
                    id =Integer.parseInt(req.getParameter("id"));
                    name = req.getParameter("name");
                }
//                check validator
                if (checkValue == false){

                    Manufacturer manufacturer = manufactureService.findById(new Manufacturer(),id);
                    req.setAttribute("manager",manufacturer);
                    req.getRequestDispatcher("addManager.jsp").forward(req, resp);
                }else {
                    Manufacturer manufacturer = new Manufacturer(id, name);
                    manufacturer.setManid(id);
                    manufacturer.setName(name);
                    manufactureService.updateManu(manufacturer);
                    resp.sendRedirect("manager?action=danh-sach-manu");
                }
            }
            break;


            default:
                break;
        }

    }


}
