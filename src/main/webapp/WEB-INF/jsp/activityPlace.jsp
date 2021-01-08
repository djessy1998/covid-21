<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 03/01/2021
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid : Place</title>


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


<!-- Lieux déjà existants -->
<div class="container">
    <div class="row">

        <div class="four columns">
            <h6>Is it one of these places ?</h6>
        </div>

    </div>

    <form:form action="/saveActivity" modelAttribute="myPlace">
    <div class="container" style="text-align: center;">
        <div class="row">


            <label>
                List of places
                <form:select path="idLieu">
                    <form:options items="${lieux}" itemValue="idLieu" itemLabel="denomination" />
                </form:select>
            </label>
        </div>
        <div class="row">
            <input class="button-primary" type="submit" name="submit" value="✓"/>
        </div>
    </div>
    </form:form>

</div>

    <br><br><br>

<!-- Lieux non existants -->

<div class="container">
    <div class="row">
        <h6>If not, please create a new : </h6>
    </div>



    <form method="POST" action="/addPlace">
        <div class="container" style="text-align: center;">
        <div class="row">

                <label>
                    Name
                    <input class="u-full-width" type="text" name="nom"/>
                </label>


        </div>

        <div class="row">

                <label>
                    Address
                    <input class="u-full-width" type="text" name="adresse"/>
                </label>

        </div>

        <div class="row">
            <input class="button-primary" type="submit" name="submit" value="Add a new place"/>
        </div>

        </div>
    </form>


</div>

    <div class="container" style="text-align: center;">
        <a href="/dashboard" class="button">Go back</a>
    </div>

</div> <!-- Fin container de toute la page -->
</body>
</html>
