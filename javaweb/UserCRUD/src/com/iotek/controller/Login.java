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
 * Created by vitme on 2016/9/3.
 */
@WebServlet(name = "Login",urlPatterns = "/login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setName(userName);
        user.setPass(userPass);

        User loadUser = userDAO.checkLogin(user);

        if (null!=loadUser){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",loadUser);
            request.getRequestDispatcher("pages/loginSuccess.jsp").forward(request,response);
        }else{
            request.setAttribute("error","用户名或密码错误");
            request.getRequestDispatcher("pages/login.jsp").forward(request,response);
        }
    }
}
