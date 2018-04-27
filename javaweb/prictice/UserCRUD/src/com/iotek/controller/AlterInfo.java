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
@WebServlet(name = "AlterInfo",urlPatterns = "/alterInfo.do")
public class AlterInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");

        user.setAge(age);
        //user.setAddress(address);

        UserDAO userDAO = new UserDAOImpl();
        String finalPage ;
        if (userDAO.updateUser(user)) {
            session.setAttribute("loginUser",user);
            finalPage = "pages/loginSuccess.jsp";
        }else{
            finalPage = "pages/alterInfo.jsp";
            request.setAttribute("error","–ﬁ∏ƒ ß∞‹«Î÷ÿ ‘");
        }
        request.getRequestDispatcher(finalPage).forward(request,response);
    }
}
