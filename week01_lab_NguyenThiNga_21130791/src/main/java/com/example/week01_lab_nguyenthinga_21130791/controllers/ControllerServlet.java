package com.example.week01_lab_nguyenthinga_21130791.controllers;

//import com.example.week01_lab_nguyenthinga_21130791.services.AccountServices;
import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.entities.GrantAccess;
import com.example.week01_lab_nguyenthinga_21130791.respositories.AccountRepository;
import com.example.week01_lab_nguyenthinga_21130791.respositories.GrantAccessRepository;
import com.example.week01_lab_nguyenthinga_21130791.respositories.LogRepository;
import com.example.week01_lab_nguyenthinga_21130791.respositories.RoleRepository;
import com.example.week01_lab_nguyenthinga_21130791.services.AccountServices;
import com.example.week01_lab_nguyenthinga_21130791.services.GrantAccessServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller",value ="/controller" )
public class ControllerServlet extends HttpServlet {
    private AccountRepository accountRepository;
    private RoleRepository roleRepository;
    private LogRepository logRepository;

    private GrantAccessRepository grantAccessRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        // Xử lý các hành động khác nhau dựa trên giá trị của action
        switch(action) {
            case "login":
                // Xử lý đăng nhập
                accountRepository = new AccountServices();
                grantAccessRepository = new GrantAccessServices();

                String accountId = req.getParameter("accountId");
                String password = req.getParameter("password");

                Account account = new Account();
                account.setAccountId(accountId);
                account.setPassword(password);

                if (accountRepository.validateAccount(account)) {
                    HttpSession session = req.getSession(true);
                    account = accountRepository.getAccountById(accountId);
                    List<String> roles = grantAccessRepository.getRolesByAccountId(accountId);

                    // Cài đặt các thuộc tính của session
                    session.setAttribute("account", accountId);
                    session.setAttribute("fullName", account.getFullName());
                    session.setAttribute("email", account.getEmail());
                    session.setAttribute("phone", account.getPhone());
                    session.setAttribute("roles", roles);

                    // Kiểm tra nếu vai trò chứa "admin"
                    boolean isAdmin = roles.contains("admin");

                    if (isAdmin) {
                        // Nếu là admin, lấy danh sách tài khoản và thiết lập thuộc tính của session
                        List<Account> accounts = accountRepository.listAccount();
                        session.setAttribute("accounts", accounts);
                        // Chuyển hướng đến dashboard
                        resp.sendRedirect("dashboard.jsp");
                    } else {
                        // Nếu không phải admin, chuyển hướng đến trang profile
                        resp.sendRedirect("profile.jsp");
                    }
                } else {
                    // Nếu xác thực tài khoản không thành công, chuyển hướng đến trang đăng nhập với thông báo lỗi
                    resp.sendRedirect("login.html?error=invalid");
                }
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
