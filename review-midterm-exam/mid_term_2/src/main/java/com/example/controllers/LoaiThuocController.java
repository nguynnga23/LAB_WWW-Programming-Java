package com.example.controllers;

import com.example.entities.LoaiThuoc;
import com.example.entities.Thuoc;
import com.example.repositories.ThuocRepository;
import com.example.services.LoaiThuocService;
import com.example.services.impl.LoaiThuocServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "loaithuoc", value = "/loaithuoc")
public class LoaiThuocController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoaiThuocService loaiThuocService = new LoaiThuocServiceImpl();
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        switch (action) {
            case "dsloaithuoc": {
                List<LoaiThuoc> dsLoaiThuoc = loaiThuocService.getAllLoaiThuoc();
                session.setAttribute("dsLoaiThuoc", dsLoaiThuoc);
                req.getRequestDispatcher("danhsachloaithuoc.jsp").forward(req, resp);
            }
            break;
        }
    }
}
