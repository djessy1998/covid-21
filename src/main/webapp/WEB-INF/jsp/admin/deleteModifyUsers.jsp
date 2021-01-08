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
    <title>Covid : Users</title>

    <!-- Mobile Specific Metas
–––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- FONT
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

    <!-- CSS
   –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <style><%@include file="/WEB-INF/css/skeleton/normalize.css"%></style>
    <style><%@include file="/WEB-INF/css/skeleton/skeleton.css"%></style>

</head>
<body>

<div class="container">

    <!-- Header -->
    <div class="container">
        <div class="row">
            <div class="one column">
                <a href="/admin/dashboard" style="text-decoration: none; text-decoration-color: #bbbbbb" title="Log out">
                    <h4>￩</h4>
                </a>
            </div>
            <div class="ten columns">
                <div style="text-align: center;">
                    <h2 class="title">Covid</h2>
                </div>
            </div>

            <div class="one column">
                <a href="/help" style="text-decoration: none; text-decoration-color: #bbbbbb" title="Help">
                    <h4>?</h4>
                </a>
            </div>
        </div>

    </div>
    <hr>
    <!-- End of header -->

    <!-- Tableau d'utilisateurs -->
    <div class="container" >
        <div class="row" style="text-align: center;"><h5>Users</h5></div>

        <table class="u-full-width">
            <thead>
            <tr>
                <th>Username</th>
                <th>First name</th>
                <th>Last name</th>
                <th> </th>
                <th> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="row">
                <form method="POST" action="/admin/modifyUser">
                    <tr>
                        <td>${user.username}</td>
                        <td>
                            <input id="userModify" name="userModify" type="hidden" value="${user.username}">
                            <input id="firstName" name="firstName" value="${user.firstName}">
                        </td>
                        <td>
                            <input id="lastName" name="lastName" value="${user.lastName}">
                        </td>
                        <td>
                            <button class="button-primary" type="submit">✓</button>
                        </td>
                    </form>
                <form method="POST" action="/admin/deleteUser">
                        <td>
                            <input id="user" name="user" type="hidden" value="${user.username}">
                            <button>ｘ</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div><!-- Fin container de toute la page -->
</body>
</html>
