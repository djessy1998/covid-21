<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 05/01/2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete users</title>
</head>
<body>

<c:forEach var="user" items="${users}" varStatus="row">
    <form method="POST" action="/admin/deleteUser">
        <h3>${user.firstName}</h3>
        <input id="user" name="user" type="hidden" value="${user.username}">
        <button>Delete the user</button>
    </form>
</c:forEach>


</body>
</html>
