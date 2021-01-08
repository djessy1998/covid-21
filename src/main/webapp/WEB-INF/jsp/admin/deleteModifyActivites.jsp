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
    <title>Covid : Activities</title>

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


    <!-- Tableau d'activités -->
    <div class="container" >
        <div class="row" style="text-align: center;"><h5>Activities</h5></div>

        <table class="u-max-full-width">
            <thead>
            <tr>
                <th>Name</th>
                <th>Place</th>
                <th>Date</th>
                <th>Start time</th>
                <th>End time</th>
                <th> </th>
                <th> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="activity" items="${activites}" varStatus="row">
                <form method="POST" action="/admin/modifyActivity">
                    <tr>
                        <td>${activity.nom}</td>
                        <td>${activity.nomLieu}</td>
                        <td>
                            <input id="activityModify" name="activityModify" type="hidden" value="${activity.id}">
                            <input id="date" name="date" value="${activity.date}">
                        </td>
                        <td>
                            <input id="heureDebut" name="heureDebut" value="${activity.heureDebut}">
                        </td>
                        <td>
                            <input id="heureFin" name="heureFin" value="${activity.heureFin}">
                        </td>
                        <td>
                            <button class="button-primary" type="submit">✓</button>
                        </td>
                </form>
                <form method="POST" action="/admin/deleteActivites">
                    <td>
                        <input id="id" name="id" type="hidden" value="${activity.id}">
                        <button>ｘ</button>
                    </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>

    </div>


</div> <!-- Fin du container de toute la page -->
</body>
</html>
