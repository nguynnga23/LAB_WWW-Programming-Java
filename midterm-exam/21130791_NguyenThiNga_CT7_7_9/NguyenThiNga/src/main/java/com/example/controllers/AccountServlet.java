package com.example.controllers;

import com.example.repositories.AccountRepository;
import com.example.services.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.entities.Account;
import java.util.List;

import java.io.IOException;

@WebServlet(name="accounts", value = "/accounts")

public class AccountServlet extends HttpServlet {
    private AccountService accountService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountService = new AccountRepository();
        String action = req.getParameter("action");
        switch (action){
            case "list-account":{
                List<Account> accounts = accountService.getAllAccounts();
                req.setAttribute("accounts", accounts);
                req.getRequestDispatcher("list-account.jsp").forward(req, resp);
            }
            break;
            case "filter-account":{
                String ten = req.getParameter("ten");
                String tieuChi = req.getParameter("tieuchi");
                if(tieuChi.equals("theoten")){
                    if(!ten.isEmpty()){
                        List<Account> accounts = accountService.getAccountByOwnerName(ten);
                        req.setAttribute("accounts", accounts);
                        req.getRequestDispatcher("list-account.jsp").forward(req, resp);
                        resp.sendRedirect("/accounts?action=list-account");
                    }else if(ten.isEmpty()){
                        List<Account> accounts = accountService.getAllAccounts();
                        req.setAttribute("accounts", accounts);
                        req.setAttribute("ten", ten);
                        req.getRequestDispatcher("list-account.jsp").forward(req, resp);
                        resp.sendRedirect("/accounts?action=list-account");
                    }
                }else if(tieuChi.equals("theotien")){
                    if(!ten.isEmpty()){
                        ten = String.valueOf(Double.parseDouble(ten));
                        List<Account> accounts = accountService.getAccountByAmount(Double.valueOf(ten));
                        req.setAttribute("accounts", accounts);
                        req.setAttribute("tien", ten);
                        req.getRequestDispatcher("list-account.jsp").forward(req, resp);
                        resp.sendRedirect("/accounts?action=list-account");
                    }else if(ten.isEmpty()){
                        List<Account> accounts = accountService.getAllAccounts();
                        req.setAttribute("accounts", accounts);
                        req.getRequestDispatcher("list-account.jsp").forward(req, resp);
                        resp.sendRedirect("/accounts?action=list-account");
                    }
                }
            }
        }
    }
}
