<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/01/2021
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Covid : Register</title>

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
                    <h4>←</h4>
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

    <!-- Registration form -->
<div class="container">
    <p> Welcome ! Please enter these information in order to register. </p>
<form method="POST" action="/register">
<div class="row">
    <div class="six columns">
        <label>Username :</label> <input class="u-full-width" type="text" name="username" required/>
    </div>

    <div class="six columns">
        <label>First name :</label><input class="u-full-width" type="text" name="firstName" required/>
    </div>
</div>

    <div class="row">
        <div class="six columns">
            <label>Password  :</label>  <input class="u-full-width" type="password" name="password" required/>
        </div>
        <div class="six columns">
            <label>Last name :</label> <input class="u-full-width" type="text" name="lastName" required/>
        </div>
    </div>

    <div class="row">
        <input class="button-primary" type="submit" name="submit"/>
    </div>



</form>
</div>
</div><!-- End of the container of the whole page -->

</body>
</html>
