package com.example.controllers;

import com.example.entities.LoaiThuoc;
import com.example.entities.Thuoc;
import com.example.repositories.ThuocRepository;
import com.example.services.LoaiThuocService;
import com.example.services.ThuocService;
import com.example.services.impl.LoaiThuocServiceImpl;
import com.example.services.impl.ThuocServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "thuoc", value = "/thuoc")
public class ThuocController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThuocService thuocService = new ThuocServiceImpl();
        LoaiThuocService loaiThuocService = new LoaiThuocServiceImpl();
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        switch (action) {
            case "addThuoc": {
                String tenThuoc = req.getParameter("tenThuoc");
                Double gia = Double.parseDouble(req.getParameter("gia"));
                Integer namSX = Integer.parseInt(req.getParameter("namSX"));
                LoaiThuoc loaiThuoc = new LoaiThuoc(Integer.parseInt(req.getParameter("loaiThuoc")));
                Thuoc thuoc = new Thuoc(tenThuoc, gia, namSX, loaiThuoc);
                thuocService.addThuoc(thuoc);
                resp.sendRedirect(req.getContextPath() + "/thuoc?action=dsthuoc");
            }
            break;
            case "updateThuoc": {
                Integer id = Integer.parseInt(req.getParameter("maThuoc"));
                Thuoc thuoc = thuocService.getThuocById(id);
                if (thuoc != null) {
                    thuoc.setTenThuoc(req.getParameter("tenThuoc"));
                    thuoc.setGia(Double.parseDouble(req.getParameter("gia")));
                    thuoc.setNameSX(Integer.parseInt(req.getParameter("nameSX")));
                    thuoc.setLoaiThuoc(new LoaiThuoc(Integer.parseInt(req.getParameter("loaiThuoc"))));
                    thuocService.updateThuoc(thuoc);
                    resp.sendRedirect(req.getContextPath() + "/thuoc?action=dsthuoc");
                }
            }
            break;
            case "deleteThuoc": {
                Integer id = Integer.parseInt(req.getParameter("id"));
                thuocService.deleteThuoc(id);
                resp.sendRedirect(req.getContextPath() + "/thuoc?action=dsthuoc");
            }
            break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThuocService thuocService = new ThuocServiceImpl();
        LoaiThuocService loaiThuocService = new LoaiThuocServiceImpl();
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        switch (action) {
            case "dsthuoc": {
                List<Thuoc> dsThuoc = thuocService.getAllThuoc();
                List<LoaiThuoc> dsLoaiThuoc = loaiThuocService.getAllLoaiThuoc();
                session.setAttribute("dsThuoc", dsThuoc);
                session.setAttribute("dsLoaiThuoc", dsLoaiThuoc);
                req.getRequestDispatcher("danhsachthuoc.jsp").forward(req, resp);
            }
            break;
            case "dsthuoctheoloaithuoc": {
                Integer maLoai = Integer.parseInt(req.getParameter("maLoai"));
                List<Thuoc> dsThuoc = thuocService.getAllThuocByLoaiThuoc(maLoai);
                session.setAttribute("dsThuoc", dsThuoc);
                req.getRequestDispatcher("danhsachthuoc.jsp").forward(req, resp);
            }
            break;
            case "dsThuoctheoten": {
                String tenThuoc = req.getParameter("tenThuoc");
                List<Thuoc> dsThuoc = thuocService.getAllThuocByTenThuoc(tenThuoc);
                session.setAttribute("dsThuoc", dsThuoc);
                req.getRequestDispatcher("danhsachthuoc.jsp").forward(req, resp);
            }
            case "update": {
                Integer id = Integer.parseInt(req.getParameter("id"));
                Thuoc thuoc = thuocService.getThuocById(id);
                if (thuoc != null) {
                    req.setAttribute("thuoc", thuoc);
                    List<LoaiThuoc> dsLoaiThuoc = loaiThuocService.getAllLoaiThuoc();
                    session.setAttribute("dsLoaiThuoc", dsLoaiThuoc);
                    req.getRequestDispatcher("themthuoc.jsp").forward(req, resp);
                }
                break;
            }
            case "add":{
                List<LoaiThuoc> loaiThuocs = loaiThuocService.getAllLoaiThuoc();
                session.setAttribute("loaiThuoc", loaiThuocs);
                req.getRequestDispatcher("themthuoc.jsp").forward(req, resp);
            }
        }
    }
}
