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
    <title>Covid</title>


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
            <a href="/logout" style="text-decoration: none; text-decoration-color: #bbbbbb" title="Log out">
                <h4>ｘ</h4>
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


    <div class="container">
        <div class="row">
            <h6>Welcome to your dashboard.</h6>
        </div>
    </div>

    <div class="container" style="text-align: center;">
        <div class="row">
            <div class="four columns">
                <img src="/images/chat.png">
                <p>
                    Add a friend

                </p>
            </div>

            <div class="four columns">
                <img src="/images/profile.png">
                <p>
                    <a href="/profile" style="text-decoration: none;">
                        My profile
                    </a>
                </p>
            </div>

            <div class="four columns">
                <img src="/images/world.png">
                <p>
                    <a href="/dashboard/notifications" style="text-decoration: none;">
                        Notifications(${NbNotifications})
                    </a>
                </p>
            </div>

        </div>
    </div>

<br><br><br>

<div class="container">
    <div class="row" style="text-align: center;">
        <form action="/positive" method="post">
            <input class="button-primary"
                   type="submit"
                   name="positive"
                   value="My test is positive"/>
        </form>
    </div>
</div>


<br><br><br> <hr>

    <!-- Tableau d'activités -->
    <div class="container" >
        <div class="row" style="text-align: center;"><h5>My activities</h5></div>

        <table class="u-full-width">
            <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Hours</th>
                <th>Place</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${activites}" varStatus="row">
                <tr>
                    <td>${item.nom}</td>
                    <td>${item.date}</td>
                    <td>${item.heureDebut}h - ${item.heureFin}h</td>
                    <td>${item.nomLieu}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <br><br><br>

    <!-- Ajout d'une activité -->
    <div class="container">
        <div class="row">
            <h6>Add an activity : </h6>
        </div>
        <form method="POST" action="/dashboard/addActivity">
            <div class="row">
                <div class="seven columns">
                    <label>
                        Name of the activity :
                        <input class="u-full-width" type="text" name="nom" required>
                    </label>
                </div>

                <div class="five columns" style="text-align: center">
                    <label>
                        Start hour : <br>
                        <input type="number" min="0" max="24" name="heureDebut" required/>
                    </label>
                </div>

            </div>

            <div class="row">
                <div class="seven columns">
                    <label for="date">
                        Date of the activity
                    </label>
                    <input type="text" placeholder="yyyy-mm-dd" id="date" name="date" required>
                </div>
                <div class="five columns" style="text-align: center">
                    <label>
                        End hour : <br>
                        <input type="number" min="0" max="24" name="heureFin" required/>
                    </label>
                </div>
            </div>


            <input class="button-primary" type="submit" name="submit" value="Let's find a place"/>
        </form>
    </div>






</div><!-- End of container of the whole page -->
</body>
</html>
