<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 06/01/2021
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete activities</title>
</head>
<body>

<c:forEach var="activity" items="${activites}" varStatus="row">
    <form method="POST" action="/admin/deleteActivites">
        <h3>${activity.nom}</h3>
        <input id="id" name="id" type="hidden" value="${activity.id}">
        <button>Delete the activity</button>
    </form>
</c:forEach>


</body>
</html>
