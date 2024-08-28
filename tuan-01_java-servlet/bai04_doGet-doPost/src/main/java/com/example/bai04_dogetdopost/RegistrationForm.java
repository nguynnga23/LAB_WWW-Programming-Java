package com.example.bai04_dogetdopost;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("LastName");
        String email = req.getParameter("Email");
        String facebook = req.getParameter("Facebook");
        String shortbio = req.getParameter("ShortBio");
        String html = "<br>" + "<html>"
                + "<head>" + "<title> Result Page </title>"
                + "</head>"
                + "<body>"
                + "First Name : " + firstName + " " + lastName + "<br>"
                + "Email : " + email + "<br>"
                + "Facebook : " + facebook + "<br>"
                + "ShortBio : " + shortbio + "<br>"
                + "</body>"
                + "</html>";
        out.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
