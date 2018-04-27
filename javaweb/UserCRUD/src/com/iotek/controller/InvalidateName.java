package com.iotek.controller;

import com.iotek.dao.UserDAO;
import com.iotek.dao.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vitme on 2016/9/6.
 */
@WebServlet(name = "InvalidateName",urlPatterns = "/invalidateName.do")
public class InvalidateName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        UserDAO userDAO = new UserDAOImpl();
        PrintWriter writer = response.getWriter();
        if(userDAO.userNameIsInvalidate(name)){
            writer.println("´æÔÚ");
        }else{
            writer.println("²»´æÔÚ");
        }
    }
}
