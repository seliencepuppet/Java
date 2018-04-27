<%--
  Created by IntelliJ IDEA.
  User: vitme
  Date: 2016/9/3
  Time: 17:19
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
    <link rel="stylesheet" type="text/css" href="styles/register.css"/>
    <title></title>
    <script type="text/javascript" src="scripts/jquery-1.8.3.min.js">
    </script>
    <script type="text/javascript">
        $(function () {
            //alert(jQuery.fn.jquery);
                    var flag = false;
            $("#un").focus(function () {
                $("#unl").css("display", "none");
                $("#unl2").css("display", "none");
            });

            $("#un").blur(function () {
                $.ajax({
                    type: "POST",
                    url: "invalidateName.do?time=" + new Date().getMilliseconds(),
                    data: "name=" + $("#un").val(),
                    dataType: "text",//回送的数据类型，text默认，xml，json
                    success: function (val) {
                        if ("存在" == $.trim(val)) {
                            flag = true;
                            $("#unl").css("display", "inline");
                        } else {
                            flag = false;
                            $("#unl2").css("display", "inline");
                        }
                    },
                    error: function () {
                        alert("服务器异常");
                    }
                });
            });

            $("input[value=submit]").click(function(){
                if(!flag){
                    $("form").submit();
                }else{
                    alert("先去处理你的用户名");
                }
            });
        });
    </script>
</head>
<body>
<div class="box">
    <form action="register.do" method="post">
        用户名:<input type="text" name="name" id="un"/>
        <label id="unl" style="color: red;display: none;">此用户名高大上已存在请重新输入</label>
        <label id="unl2" style="color: green;display: none;">恭喜通过验证</label>
        <br/>
        密码：<input type="password" name="pass"/><br/>
        重复密码：<input type="password"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="button" value="submit"/>
    </form>
</div>
<%
    Object error = request.getAttribute("error");
    if (null != error) {
        out.println(error);
    }
%>
</body>
</html>
