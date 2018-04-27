<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/6
  Time: 13:42
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
    <script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            setInterval("changeVal()",1000);
            setTimeout("changeLocation()",5000);
        });
        function changeVal(){
            $("#rs").text($("#rs").text()-1);
        }
        function changeLocation(){
            window.location.href="pages/login.jsp";
        }
    </script>
</head>
<body>
    恭喜<%=request.getAttribute("userName")%> 注册成功<br/>
    页面将在&nbsp;<span id="rs">5</span>&nbsp;秒后自动跳到登录页面<br/>
    <a href="pages/login.jsp">手动操作</a>

</body>
</html>
