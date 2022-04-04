<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2022/4/4
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script rel="stylesheet" type="text/css" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/admin/login">
    <input type="text" name="name" placeholder="请输入用户名"><br>
    <input type="text" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置"><br>
</form>
<div>
    ${error}
</div>
</body>
</html>
