package com.akash.controllers;

import com.akash.database.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddItem")
public class AddItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int listId = Integer.parseInt(request.getParameter("ListId"));
        String item = request.getParameter("item");
        boolean itemResult = DAO.getInstance().addItem(listId,item);
        response.sendRedirect("GetLists");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("Kahan bhai?");
    }
}
