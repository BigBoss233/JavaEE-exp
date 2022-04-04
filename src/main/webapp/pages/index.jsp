<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2022/3/9
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script>
        function logout() {
            if (confirm("您确认注销？")) {
                $.get("${pageContext.request.contextPath}/admin/logout",function (){
                    alert("注销成功!")
                    location.href = "${pageContext.request.contextPath}/pages/login.jsp"
                })
            }
        }
    </script>
</head>
<body class="container">
<a href="${pageContext.request.contextPath}/department/findAll">查看部门</a>
<a href="${pageContext.request.contextPath}/employee/findAll">查看人员</a>
<div style="float: right" id="app">
    欢迎您:${admin.name}!
    <a href="javascript:void(0)" onclick="logout()">注销</a>
</div>
</body>
</html>
