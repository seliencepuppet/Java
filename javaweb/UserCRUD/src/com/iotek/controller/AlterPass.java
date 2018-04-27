package com.iotek.controller;

import com.iotek.dao.UserDAO;
import com.iotek.dao.UserDAOImpl;
import com.iotek.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vitme on 2016/9/6.
 */
@WebServlet(name = "AlterPass",urlPatterns = "/alterPass.do")
public class AlterPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String old = request.getParameter("old");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        //TODO add check pass code here if true set new param to user object
        UserDAO userDAO = new UserDAOImpl();

    }
}
