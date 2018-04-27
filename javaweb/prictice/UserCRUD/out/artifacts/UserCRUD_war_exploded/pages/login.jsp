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
<% Object val = request.getAttribute("error");%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <form action="login.do" method="post">
        用户名；<input type="text" name="userName"/><br/>
        密码:<input type="password" name="userPass"/><br/>
        <input type="submit"/>
    </form>
    <a href="pages/register.jsp">注册</a>
    <%
        if (null!=val){
            out.println("用户名或密码错误");
        }
    %>
</body>
</html>
