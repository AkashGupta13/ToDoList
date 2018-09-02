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

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        User user = new User(username,password);
        DAO dao = DAO.getInstance();
        PrintWriter out = response.getWriter();
        int userid = dao.loginUser(user);
        if(userid > 0){
            request.getSession().setAttribute("userid",userid);
            out.println("Login successfull! " + request.getAttribute("userid"));
            request.getRequestDispatcher("/GetLists").forward(request,response);
        }
        else{
            out.println("Login failed!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
