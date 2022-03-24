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
<form action="${pageContext.request.contextPath}/department/insert" method="post">
    number:<input type="text" name="number"><br>
    name:<input type="text" name="name"><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
