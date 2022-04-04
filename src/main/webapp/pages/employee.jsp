<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2022/3/3
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script rel="stylesheet" type="text/css" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script>
        function delUser(userId) {
            if (confirm("确认要删除吗？")) {
                $.get("${pageContext.request.contextPath}/employee/del", {id: userId}, function () {
                    location.href = "${pageContext.request.contextPath}/employee/findAll"
                })
            }
        }
    </script>
</head>
<body class="container">
<h1>员工列表</h1>
<form action="${pageContext.request.contextPath}/employee/fuzzyFind" method="post">
    姓名:<input type="text" name="name">
    工号:<input type="text" name="number">
    性别:<input type="text" name="gender">
    <input type="submit" value="查询">
</form>
<table class="table">
    <c:forEach items="${pageInfo.list}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.number}</td>
            <td>${order.name}</td>
            <td>${order.gender}</td>
            <td>${order.age}</td>
            <td>${order.dep_name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/employee/updateUI?id=${order.id}" class="btn btn-default"
                   role="button">修改</a>
            </td>
            <td>
                <a href="javascript:void(0)" onclick="delUser(${order.id})" class="btn btn-default" role="button">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/pages/employee-add.jsp" class="btn btn-default"
               role="button">添加</a>
        </td>
    </tr>
</table>
<a href="?dep_id=${employeeParam.dep_id}&&name=${employeeParam.name}&&gender=${employeeParam.gender}&&number=${employeeParam.number}&&page=${pageInfo.firstPage}"
   class="btn btn-default" role="button">首页</a>
<c:choose>
    <c:when test="${pageInfo.isFirstPage}">
        <a href="?dep_id=${employeeParam.dep_id}&&name=${employeeParam.name}&&gender=${employeeParam.gender}&&number=${employeeParam.number}&&page=${pageInfo.firstPage}"
           class="btn btn-default" role="button">上一页</a>
    </c:when>
    <c:otherwise>
        <a href="?dep_id=${employeeParam.dep_id}&&name=${employeeParam.name}&&gender=${employeeParam.gender}&&number=${employeeParam.number}&&page=${pageInfo.prePage}"
           class="btn btn-default" role="button">上一页</a>
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${pageInfo.isLastPage}">
        <a href="?dep_id=${employeeParam.dep_id}&&name=${employeeParam.name}&&gender=${employeeParam.gender}&&number=${employeeParam.number}&&page=${pageInfo.lastPage}"
           class="btn btn-default" role="button">下一页</a>
    </c:when>
    <c:otherwise>
        <a href="?dep_id=${employeeParam.dep_id}&&name=${employeeParam.name}&&gender=${employeeParam.gender}&&number=${employeeParam.number}&&page=${pageInfo.nextPage}"
           class="btn btn-default" role="button">下一页</a>
    </c:otherwise>
</c:choose>
<a href="?dep_id=${employeeParam.dep_id}&&name=${employeeParam.name}&&gender=${employeeParam.gender}&&number=${employeeParam.number}&&page=${pageInfo.lastPage}"
   class="btn btn-default" role="button">尾页</a>
<a href="${pageContext.request.contextPath}/pages/index.jsp" class="btn btn-default">返回</a>
</body>
</html>
