<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2022/3/3
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/department/update" method="post">
    <input type="hidden" name="id" value="${id}">
    name:<input type="text" name="name"><br>
    number:<input type="text" name="number"><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
