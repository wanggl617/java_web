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
    <script>
        function deleteUser(id) {
            //用户安全提示：
            if(confirm("确认删除？")){
                location.href="${PageContext.request.contextPath}/User_war_exploded/delUserServlet?id="+id;
            }
        }
        function test(){

                var flag = false;
                var all_id = document.getElementsByName("uid");
                for(var i = 0; i < all_id.length;i++) {
                    if (all_id[i].checked) {
                        flag = true;
                        break;
                    }
                }
            if(flag==true && confirm("确认删除联系人")) {
                document.getElementById("from").submit();
            }

        }
        function selAll(){
            var fir = document.getElementById("fit_uid");
            var all_id = document.getElementsByName("uid");
            for(var i = 0; i < all_id.length;i++){
                all_id[i].checked = fir.checked;
            }

        }
        // window.onload = function ()
        // {
        //     document.getElementById("fit_uid").onclick = function (){
        //     var cbs = document.getElementsByName("uid");
        //     for (var i = 0; i < cbs.length; i++) {
        //         cbs[i].checked = this.checked;
        //         }
        //     }
        // }

    </script>
</head>
<body background="image/1.jpg";background-size:100% 100%;>
<div class="table1">
    <h1 style=" color: #0a0a0a;
            height: 30px;
            font-size: 20px;
            text-align: center;
            margin-top: -30px;">用户列表信息</h1>
    <div style="float: left;padding-left: 80px;color: #131313">
        <form class="form-inline" action="${pageContext.request.contextPath}/findByPageServlet" method="post">
            <div class="form-group" style="display:inline-block;">
                <label for="exampleInputName2">Name</label>
                <input type="text" class="form-control" name="name" value="${condition.name[0]}" id="exampleInputName2" placeholder="">
            </div>
            <div class="form-group" style="display:inline-block">
                <label for="exampleInputEmail2">Email</label>
                <input type="text" class="form-control" name="email" value="${condition.email[0]}" id="exampleInputEmail2" placeholder="">
            </div>
            <button style="display:inline-block" type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px;padding-right: 80px;">
            <a style="color: #2644e2" href="add.jsp">添加联系人</a>
            <a style="color: #2644e2" onclick="test()" id="deletecheck">删除联系人</a>
    </div>
<form id="from" action="delSelectServlet" method="post">
    <table class="table-head" align="center" border="0.5" >
    <tr style="color: #7e95f6;font-size: 20px;height: 30px;">
        <th><input type="checkbox" id="fit_uid" onclick="selAll()" ></th>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>地址</td>
        <td>QQ</td>
        <td>Email</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${pageBean.list}" var="user" varStatus="s">
        <tr style="height: 30px;">
            <th><input type="checkbox" name="uid" value="${user.id}"></th>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                <a href="javascript:deleteUser(${user.id});">删除</a></td>
        </tr>
    </c:forEach>
</table>
</form>
<nav aria-label="Page navigation" style="
    position: absolute;
    top: 500px;
    left: 70px;
    right: 0;
    bottom: 0;
    margin: auto;
">
    <ul class="pagination" style="
    position: absolute;
    top: 20px;
">
        <c:if test="${pageBean.currentPage == 1}">
            <li class="disabled">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
        </c:if>
        <c:if test="${pageBean.currentPage != 1}">
            <li >
            <a href="${pageContext.request.contextPath}/findByPageServlet?currentPage=${pageBean.currentPage - 1}&rows=12" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </c:if>

        </li>
        <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
            <c:if test="${pageBean.currentPage == i}">
                <li class="active">
            </c:if>
            <c:if test="${pageBean.currentPage != i}">
                <li class="">
            </c:if>
            <a href="${pageContext.request.contextPath}/findByPageServlet?currentPage=${i}&rows=12&name=${condition.name[0]}&email=${condition.email[0]}">${i}</a></li>
        </c:forEach>
        <c:if test="${pageBean.currentPage == pageBean.totalPage}">
            <li class="disabled">
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
        </c:if>
        <c:if test="${pageBean.currentPage != pageBean.totalPage}">
            <li>
                <a href="${pageContext.request.contextPath}/findByPageServlet?currentPage=${pageBean.currentPage + 1}&rows=12" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
        </c:if>

        </li>
    </ul>
</nav>

</div>
</body>
</html>
