<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/3
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <a href="pages/login.jsp">去登录</a><br/>

    <a href="pages/register.jsp">去注册</a>
</body>
</html>
