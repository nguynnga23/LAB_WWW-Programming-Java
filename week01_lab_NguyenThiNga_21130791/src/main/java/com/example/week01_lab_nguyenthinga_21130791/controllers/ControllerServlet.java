package com.example.week01_lab_nguyenthinga_21130791.controllers;

//import com.example.week01_lab_nguyenthinga_21130791.services.AccountServices;
import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.respositories.AccountRepository;
import com.example.week01_lab_nguyenthinga_21130791.services.AccountServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "controller",value ="/controller" )
public class ControllerServlet extends HttpServlet {
    private AccountRepository accountRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        // Xử lý các hành động khác nhau dựa trên giá trị của action
        switch(action) {
            case "login":
                // Xử lý đăng nhập
                accountRepository = new AccountServices();
                String accountId = req.getParameter("accountId");
                String password = req.getParameter("password");

                Account account = new Account();
                account.setAccountId(accountId);
                account.setPassword(password);
                if (accountRepository.validateAccount(account)) {
                    RequestDispatcher rd = req.getRequestDispatcher("/dashboard.jsp");
                    rd.forward(req, resp);
                } else {
                    resp.sendRedirect("login.html?error=invalid");
                }
                break;
            case "addAccount":
                // Thêm tài khoản
                break;
            case "updateAccount":
                // Cập nhật tài khoản
                break;
            case "deleteAccount":
                // Xóa tài khoản
                break;
            case "showAccountInfo":
                // Hiển thị thông tin tài khoản
                break;
            case "showRoleAccounts":
                // Hiển thị các account của một role
                break;
            case "grantRole":
                // Cấp quyền cho một account
                break;
            default:
                // Xử lý các hành động khác
                break;
        }
    }
}
