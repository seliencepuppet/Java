<%@ page import="com.iotek.model.User" %>
<%@ page import="com.iotek.model.UserDetails" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/3
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    User user = (User) session.getAttribute("loginUser");
    Set<UserDetails> userDetailsSet = user.getUserDetailsSet();
%>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        img{
            width: 100px;
            height: 100px;
        }
    </style>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <img src="<%=user.getImg()%>"/>恭喜 <%=user.getName()%>  登录成功<br/>
    您的年龄是:<%=user.getAge()%> 岁<br/>
    <a href="pages/alterInfo.jsp">修改个人信息</a><br/>
    <a href="pages/alterPass.jsp">修改密码</a><br/>
    <a href="pages/alterImg.jsp">修改头像</a><br/>
    <a href="pages/showDetails.jsp">查看详细信息</a>
</body>
</html>
