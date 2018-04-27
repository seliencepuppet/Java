package com.iotek.controller;

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
@WebServlet(name = "FindDetails",urlPatterns = "/findDetails.do")
public class FindDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id").trim();
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        Set<UserDetails> userDetailsSet = user.getUserDetailsSet();
        UserDetails userDetails = null;
        for (UserDetails details : userDetailsSet) {
            if (details.getId().trim().equals(id)){
                userDetails = details;
                break;
            }
        }
        String finalPage;
        if ("alt".equals(type)){//修改
            finalPage = "pages/alterDetails.jsp";
            request.setAttribute("altDetails",userDetails);
        }else{//删除
            finalPage = "pages/loginSuccess.jsp";
            if(new UserDAOImpl().deleteDetails(userDetails)){
                userDetailsSet.remove(userDetails);//删除查找到的对象
                user.setUserDetailsSet(userDetailsSet);
                session.setAttribute("loginUser",user);
            }
        }
        request.getRequestDispatcher(finalPage).forward(request, response);

    }
}
