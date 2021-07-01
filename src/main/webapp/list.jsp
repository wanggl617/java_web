<%--
  Created by IntelliJ IDEA.
  Date: 2021/6/8
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body background="image/1.jpg";background-size:100% 100%;>
<div class="table1">
    <h1 style=" color: #0a0a0a;
            height: 30px;
            font-size: 20px;
            text-align: center;
            margin-top: -30px;">用户列表信息</h1>
    <div style="float: left;padding-left: 80px;color: #131313">
        <form class="form-inline">
            <div class="form-group" style="display:inline-block;">
                <label for="exampleInputName2">Name</label>
                <input type="text" class="form-control" id="exampleInputName2" placeholder="">
            </div>
            <div class="form-group" style="display:inline-block">
                <label for="exampleInputEmail2">ID</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="">
            </div>
            <button style="display:inline-block" type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px;padding-right: 80px;">
            <a style="color: #d6dbf5" href="add.jsp">添加联系人</a>
            <a style="color: #d6dbf5">删除联系人</a>
    </div>


<table class="table-head" align="center" border="0.5" >
    <tr style="color: #7e95f6;font-size: 20px;height: 30px;">
        <th></th>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>地址</td>
        <td>QQ</td>
        <td>Email</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${users}" var="user" varStatus="s">
        <tr style="height: 30px;">
            <th><input type="checkbox"></th>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
