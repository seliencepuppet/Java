<%@ page import="com.iotek.model.User" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.iotek.model.UserDetails" %>
<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/8
  Time: 10:05
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
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <%
        if (null==userDetailsSet||0==userDetailsSet.size()){
            out.println("抱歉您还没个人信息请添加");
        }else{
            for (UserDetails userDetails : userDetailsSet) {
    %>
    地址:<%=userDetails.getAddress()%>&nbsp;电话:<%=userDetails.getPhone()%>&nbsp;邮编：<%=userDetails.getPostid()%>&nbsp;&nbsp;<a href="findDetails.do?id=<%=userDetails.getId()%>&type=alt">修改</a>&nbsp;&nbsp;<a href="findDetails.do?id=<%=userDetails.getId()%>&type=del">删除</a><br/>
    <%
            }
        }
    %>
    <a href="#">添加详细信息</a>
</body>
</html>
