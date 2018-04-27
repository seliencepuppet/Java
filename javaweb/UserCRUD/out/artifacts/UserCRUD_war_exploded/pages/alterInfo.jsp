<%@ page import="com.iotek.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/6
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%
    User user = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <form action="alterInfo.do" method="post">
        年龄:<input type="text" name="age" value="<%=user.getAge()%>"/><br/>
        地址:<input type="text" name="address" value="<%=user.getAddress()%>"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
