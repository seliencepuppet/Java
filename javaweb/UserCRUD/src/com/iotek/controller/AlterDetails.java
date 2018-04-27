package com.iotek.controller;

import com.iotek.dao.UserDAO;
import com.iotek.dao.UserDAOImpl;
import com.iotek.model.User;
import com.iotek.model.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * Created by vitme on 2016/9/8.
 */
@WebServlet(name = "AlterDetails",urlPatterns = "/alterDetails.do")
public class AlterDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String postid = request.getParameter("postid");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        Set<UserDetails> userDetailsSet = user.getUserDetailsSet();
        UserDetails oldDetails = null;
        for (UserDetails userDetails : userDetailsSet) {
            if (userDetails.getId().equals(id)){
                oldDetails = userDetails;
            }
        }
        UserDetails beUpdateDetails = new UserDetails();
        beUpdateDetails.setId(id);
        beUpdateDetails.setAddress(address);
        beUpdateDetails.setPhone(phone);
        beUpdateDetails.setPostid(postid);
        beUpdateDetails.setUserID(oldDetails.getUserID());

        UserDAO userDAO = new UserDAOImpl();
        if (userDAO.updateDetails(beUpdateDetails)){
            userDetailsSet.remove(oldDetails);
            userDetailsSet.add(beUpdateDetails);
            user.setUserDetailsSet(userDetailsSet);
            session.setAttribute("loginUser",user);

        }
        request.getRequestDispatcher("pages/loginSuccess.jsp").forward(request,response);

    }
}
