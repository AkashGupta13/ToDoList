package com.akash.controllers;

import com.akash.database.DAO;
import com.akash.entities.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetLists")
public class GetLists extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int userid = (int) request.getSession().getAttribute("userid");
            ArrayList<List> lists = DAO.getInstance().getLists(userid);
            request.setAttribute("lists",lists);
            request.getRequestDispatcher("/lists.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("/index.jsp");
        }
    }
}
