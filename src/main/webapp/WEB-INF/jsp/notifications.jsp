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
    <title>Covid : My notifications</title>

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
            <a href="/login" style="text-decoration: none; text-decoration-color: #bbbbbb" title="Main page">
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

<h6>My notifications</h6>

    <div class="container">
        <table class="u-full-width">
            <thead>
            <tr>
                <th>Number</th>
                <th>Content</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${notifications}" varStatus="row">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.contenu}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div> <!-- Fin du container de toute la page-->
</body>
</html>
