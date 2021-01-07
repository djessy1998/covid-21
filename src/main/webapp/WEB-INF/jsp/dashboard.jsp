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
    <h3>${item.nom} | ${item.date} | ${item.heureDebut}h - ${item.heureFin}h</h3>
    <h4>Lieu - ${item.nomLieu}</h4>
</c:forEach>

<form method="POST" action="/dashboard/addActivity">


    <label>
        Name of the activity
        <input type="text" name="nom">
    </label>

    <label for="date">
        Date of the activity
    </label>
    <input type="text" placeholder="yyyy-mm-dd" id="date" name="date">

    <label>
        Start hour
        <input type="number" min="0" max="24" name="heureDebut"/>
    </label>

    <label>
        End hour
        <input type="number" min="0" max="24" name="heureFin"/>
    </label>

    <input type="submit" name="submit" value="+"/>
</form>

<br><a href="/logout">Logout</a>

<a href="/profile">Profile</a>
<a href="/addfriend">Add a friend</a>
<a href="/dashboard/notifications">Notifications : ${NbNotifications}</a>

<form action="/positive" method="post">
    <input type="submit" name="positive" value="My test is positive"/>
</form>

</body>
</html>
