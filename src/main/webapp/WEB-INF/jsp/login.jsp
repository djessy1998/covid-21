<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/12/2020
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Welcome to Spring Boot Security</h1>

<form method="POST" action="/login">
    User Name : <input type="text" name="username" value="user"/><br><br>
    Password  : <input type="password" name="password" value="password"/><br><br>
    <input type="submit" name="submit"/>
</form>

</body>
</html>
