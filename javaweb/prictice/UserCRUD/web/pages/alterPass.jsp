<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/6
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <form action="" method="post">
        旧密码:<input type="password" name="old"/><br/>
        新密码:<input type="password" name="pass"/><br/>
        重复密码:<input type="password"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
