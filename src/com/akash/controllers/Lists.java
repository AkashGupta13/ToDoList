package com.akash.controllers;

import com.akash.database.DAO;
import com.akash.entities.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Lists")
public class Lists extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listName = request.getParameter("listName");

        try {
            int userid = (int) request.getSession().getAttribute("userid");
            List newList = new List(userid,listName);
            PrintWriter out = response.getWriter();
            DAO dao = DAO.getInstance();
            dao.addList(newList);
            request.getRequestDispatcher("/GetLists").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("/lists.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
