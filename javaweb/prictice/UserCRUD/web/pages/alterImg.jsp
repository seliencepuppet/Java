<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/8
  Time: 15:36
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
    <form action="alterImg.do" method="post" enctype="multipart/form-data">
        请选择头像:<input type="file" name="img"/><br/>
        <input type="submit"/>
    </form>
<%
    Object obj = request.getAttribute("error");
    if(null!=obj){
        out.print(obj);
    }
    %>
</body>
</html>
