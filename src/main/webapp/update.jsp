<%--
  Created by IntelliJ IDEA.
  Date: 2021/6/4
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <style>
        * {
            margin: 0;
            padding: 3px;
        }
        .show{

            background: rgba(250, 246, 246, 0.5);
            width: 500px;
            height: 500px;
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
</head>
<body background="image/1.jpg";background-size:100% 100%;>
<div class="show">

    <div class="login-title">
        <span>修改联系人</span>
    </div>
    <form class="login-con" action="updateServlet" method="post">
        <!--隐藏域 提交id-->
        <input type="hidden" name="id" value="${user.id}">
        <div class="user">
            <div class="sp">姓名</div><input name="name" type="text" value="${user.name}" readonly="readonly" placeholder="姓名">
<!-- readonly : 只读，不可修改-->
        </div>
        <div class="user">
            <div class="sp">性别</div>
            <c:if test="${user.gender =='男'}">
                <input name="gender" type="radio" value="男" checked>男
                <div style="width: 30px;display: inline-block"></div>
                <input name="gender" type="radio" value="女">女
            </c:if>
            <c:if test="${user.gender =='女'}">
                <input name="gender" type="radio" value="男" >男
                <div style="width: 30px;display: inline-block"></div>
                <input name="gender" type="radio" value="女" checked>女
            </c:if>
        </div>
        <div class="user">
            <div class="sp">年龄</div><input name="age" type="text" value="${user.age}" placeholder="年龄">
        </div>
        <div class="user">
            <div class="sp">地址</div><input name="address" type="text" value="${user.address}" placeholder="地址">
        </div>
        <div class="user">
            <div class="sp">QQ</div><input name="qq" type="text" value="${user.qq}" placeholder="qq">
        </div>
        <div class="user">
            <div class="sp">Email</div><input name="email" type="text" value="${user.email}" placeholder="email">
        </div>

        <div>
            <input type="submit" value="提交">
        </div>

    </form>
</div>
</body>
</html>
