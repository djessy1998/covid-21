<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/12/2020
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h1>Welcome to Spring Boot User DashBoard</h1>

<h2>You are in Spring Boot User DashBoard Page</h2>

<c:forEach var="item" items="${activites}" varStatus="row">
    <h2>${item.date}</h2>
    <h3>${item.heureDebut}h - ${item.heureFin}h</h3>
</c:forEach>

<br><a href="/logout">Logout</a>

<a href="/profile">Profile</a>
<a href="/addfriend">Add a friend</a>
<a href="/dashboard">My test is positive</a>

</body>
</html>
