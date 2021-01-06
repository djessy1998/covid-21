<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 06/01/2021
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete places</title>
</head>
<body>

<c:if test="${empty lieux}">
    <h2>There is no places to display</h2>
</c:if>

<c:forEach var="lieu" items="${lieux}" varStatus="row">
    <form method="POST" action="/admin/deletePlaces">
        <h3>${lieu.denomination}</h3>
        <h2>${lieu.adresse}</h2>
        <input id="id" name="id" type="hidden" value="${lieu.idLieu}">
        <button>Delete the place</button>
    </form>
</c:forEach>


</body>
</html>
