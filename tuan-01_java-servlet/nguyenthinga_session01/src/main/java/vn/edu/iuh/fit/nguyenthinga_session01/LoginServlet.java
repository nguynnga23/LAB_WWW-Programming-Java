package vn.edu.iuh.fit.nguyenthinga_session01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.nguyenthinga_session01.beans.LoginBean;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LoginBean lg = new LoginBean();
        PrintWriter out = resp.getWriter();
        boolean result = lg.login(username, password);

        if(result)
            out.println("Welcome, " + username);
        else
            out.println("Login failed");
    }
}
