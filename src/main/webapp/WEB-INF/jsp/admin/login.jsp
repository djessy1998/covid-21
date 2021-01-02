<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/12/2020
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login admin</title>
</head>
<body>

<h1>Welcome to Admin Spring Boot Security</h1>

<form method="POST" action="/admin/login">
    User Name : <input type="text" name="username" value="admin"/><br><br>
    Password  : <input type="password" name="password" value="password"/><br><br>
    <input type="submit" name="submit"/>
</form>

</body>
</html>
