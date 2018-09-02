package com.akash.controllers;

import com.akash.database.DAO;
import com.akash.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        User user = new User(username,password);
        DAO dao = DAO.getInstance();
        PrintWriter out = response.getWriter();
        if(dao.registerUser(user)){
            out.println("Registered successfully!");
        }
        else{
            out.println("Registration failed!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
