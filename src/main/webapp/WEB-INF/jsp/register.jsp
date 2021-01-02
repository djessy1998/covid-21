<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/01/2021
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form method="POST" action="/register">
    Username : <input type="text" name="username" value="user"/><br><br>
    First name : <input type="text" name="firstName" value="firstName"/><br><br>
    Last name : <input type="text" name="lastName" value="lastName"/><br><br>
    Password  : <input type="password" name="password" value="password"/><br><br>
    <input type="submit" name="submit"/>
</form>

</body>
</html>
