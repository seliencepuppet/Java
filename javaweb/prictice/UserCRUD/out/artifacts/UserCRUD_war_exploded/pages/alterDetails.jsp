<%@ page import="com.iotek.model.UserDetails" %>
<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/8
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    UserDetails userDetails = (UserDetails) request.getAttribute("altDetails");
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <form action="alterDetails.do" method="post">
        <input type="hidden" name="id" value="<%=userDetails.getId()%>"/>
        地址:<input type="text" name="address" value="<%=userDetails.getAddress()%>"/><br/>
        电话:<input type="text" name="phone" value="<%=userDetails.getPhone()%>"/><br/>
        邮编:<input type="text" name="postid" value="<%=userDetails.getPostid()%>"/><br/>
        <input type="submit"/>
    </form>

</body>
</html>
