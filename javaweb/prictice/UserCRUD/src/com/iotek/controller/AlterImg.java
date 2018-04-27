package com.iotek.controller;

import com.iotek.dao.UserDAO;
import com.iotek.dao.UserDAOImpl;
import com.iotek.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by vitme on 2016/9/8.
 */
@WebServlet(name = "AlterImg",urlPatterns = "/alterImg.do")
@MultipartConfig
public class AlterImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("img");

        String contentType = part.getContentType();
        boolean flag1 = contentType.equalsIgnoreCase("image/jpeg");
        boolean flag2 = contentType.equalsIgnoreCase("image/png");
        String path = request.getServletContext().getRealPath("/");//得到Web运行的根目录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        UserDAO userDAO = new UserDAOImpl();
        if (flag1){
            part.write(path+"images/"+user.getName()+".jpg");
            user.setImg("images/" + user.getName() + ".jpg");
            userDAO.updateUser(user);
            session.setAttribute("loginUser", user);
            request.getRequestDispatcher("pages/loginSuccess.jsp").forward(request,response);
        }else if (flag2){
            part.write(path+"images/"+user.getName()+".png");
            user.setImg("images/" + user.getName() + ".png");
            userDAO.updateUser(user);
            session.setAttribute("loginUser", user);
            request.getRequestDispatcher("pages/loginSuccess.jsp").forward(request, response);
        }else{
            request.setAttribute("error", "只支持jpg或png");
            request.getRequestDispatcher("pages/alterImg.jsp").forward(request, response);
        }
    }
}
