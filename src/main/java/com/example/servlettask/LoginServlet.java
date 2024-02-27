package com.example.servlettask;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

         if (username.equals("fouad") && password.equals("123")){
            request.getSession().setAttribute("auth", username);
            response.sendRedirect("/home.jsp");
        }else {
            response.getWriter().println("login failed, please try again...");
        }
    }
}








