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
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script>
        function delDep(departmentId) {
            if (confirm("确认要删除吗？")) {
                $.get("${pageContext.request.contextPath}/department/del", {id: departmentId}, function () {
                    location.href = "${pageContext.request.contextPath}/department/findAll"
                })
            }
        }
    </script>
</head>
<body>
<h1>部门列表</h1>
<table>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.number}</td>
            <td>${department.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/employee/findByDepId?dep_id=${department.id}">查看部门人员</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/department/updateUI?id=${department.id}">修改</a>
            </td>
            <td>
                <a href="javascript:void(0)" onclick="delDep(${department.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/pages/department-add.jsp">添加</a>
        </td>
    </tr>
</table>
</body>
</html>
