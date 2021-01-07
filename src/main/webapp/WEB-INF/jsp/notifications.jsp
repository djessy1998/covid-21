<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 06/01/2021
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notifications</title>
</head>
<body>

<h1>List of notifications</h1>

<c:forEach var="item" items="${notifications}" varStatus="row">
    <h3>${item.id} - ${item.contenu}</h3>
</c:forEach>


</body>
</html>
