<%--
  Created by IntelliJ IDEA.
  Date: 2021/6/4
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 3px;
        }
        .show{

            background: rgba(0, 0, 0, 0.5);
            width: 400px;
            height: 300px;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            margin: auto;
            padding: 100px 40px 40px 40px;
            box-shadow: -15px 15px 15px rgba(6, 17, 47, 0.2);
            z-index: 99999;
            text-align: center;
        }
        .login-title {
            color: #D3D7F7;
            height: 60px;
            font-size: 20px;
            text-align: center;
            margin-top: -20px;
        }
        .login-con {
            height: 208px;
            position: absolute;
            left: 0;
            width: 80%;
            margin: 0 10%;
        }

        .user {
            position: relative;
            height: 50px;
        }
        .sp{
            color: #d6dbf5;
            width: 80px;
            display: inline-block;
            text-align: center;
            position: absolute;
            left: 5%;
        }
        .no{
            color: red;
        }
    </style>
    <script>
        /**
         * 分析：点击超链接，或者图片，需要换一张
         * 1.给超链接 和 图片绑定单机事件
         * 2.重新设置图片的src属性
         */
        window.onload = function (){
            //获取图片对象
            var img = document.getElementById("checkCode");
            //绑定单击事件
            img.onclick = function (){
                var date = new Date().getTime();
                img.src="check?"+date;
            }
            var img_w = document.getElementById("checkCode_w");
            img_w.onclick = function (){
                var date = new Date().getTime();
                img_w.href="index.jsp"
            }
        }
    </script>
</head>
<body background="image/1.jpg";background-size:100% 100%;>
<div class="show">

<div class="login-title">
    <span>管理员登录</span>
</div>
<form class="login-con" action="LoginServlet" method="post">
    <div class="user">
        <div class="sp">用户名</div><input name="username" type="text" placeholder="用户名">
    </div>
    <div class="user">
        <div class="sp">密码</div><input name="password" type="password" placeholder="密码">
    </div>
    <div class="">
        <div class="sp">验证码</div><input name="checkcode" type="text" placeholder="验证码">
    </div>
    <div>
        <span class="sp"></span><img id="checkCode" src="check">
    </div>
    <div>
        <span class="sp"></span><a id="checkCode_w" href="check">看不清换一张？</a>
    </div>
    <div>
        <input type="submit" value="submit">
    </div>

    <div class="no">

        <%--        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
        ${requestScope.msg}
    </div>
    <div class="no">

        <%--        <%=request.getAttribute("user_msg")==null?"":request.getAttribute("user_msg")%>--%>
        ${requestScope.user_msg}
    </div>
</form>
</div>
</body>
</html>
