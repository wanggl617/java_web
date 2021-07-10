<%--
  Created by IntelliJ IDEA.
  Date: 2021/6/8
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用户信息</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .show{

            /*background: rgba(172, 244, 246,0.6);*/
            background: rgba(6, 17, 47, 0.2);
            width: 540px;
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
            text-decoration: none;
            color: #d6dbf5;
            height: 60px;
            font-size: 20px;
            text-align: center;
            margin-top: -20px;

        }
    </style>
</head>
<body background="image/1.jpg";background-size:100% 100%;>
<div class="show">
    <a class="login-title" href="findByPageServlet">
        查询所有用户信息
    </a>
</div>

</body>
</html>
