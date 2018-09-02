package com.akash.controllers;

import com.akash.database.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteList")
public class DeleteList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int listId = Integer.parseInt(request.getParameter("ListId"));
        boolean isDeleted = DAO.getInstance().deleteList(listId);
        if(isDeleted)
            out.println("deleted successfully bhai!");
        else
            out.println("could not delete!");
        response.sendRedirect("GetLists");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw  new ServletException("Method not supported niggah, no bakchodi please!");
    }
}
