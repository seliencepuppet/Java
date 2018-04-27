package com.iotek.controller;

import com.iotek.dao.UserDAO;
import com.iotek.dao.UserDAOImpl;
import com.iotek.model.User;
import com.iotek.util.IDType;
import com.iotek.util.RoundID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitme on 2016/9/3.
 */
@WebServlet(name = "Register", urlPatterns = "/register.do")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id = new RoundID().getID(IDType.USER);
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        int age = Integer.parseInt(request.getParameter("age"));


        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPass(pass);
        user.setAge(age);

        UserDAO userDAO = new UserDAOImpl();

        if (userDAO.createUser(user)) {
            System.out.println("×¢²á³É¹¦");
            request.setAttribute("userName",name);
            request.getRequestDispatcher("pages/registerSuccess.jsp").forward(request, response);
        }else{
            System.out.println("×¢²áÊ§°Ü");
        }

    }
}
