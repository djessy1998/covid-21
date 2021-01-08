<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/12/2020
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid : Admin </title>

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
                <a href="/admin/logout" style="text-decoration: none; text-decoration-color: #bbbbbb" title="Log out">
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
                <img src="/images/user.png">
                <p>
                    <a href="/admin/deleteModifyUsers" style="text-decoration: none;">
                        Users
                    </a>
                </p>
            </div>

            <div class="four columns">
                <img src="/images/map.png">
                <p>
                    <a href="/admin/deleteModifyPlaces" style="text-decoration: none;">
                        Places
                    </a>
                </p>
            </div>

            <div class="four columns">
                <img src="/images/calendar.png">
                <p>
                    <a href="/admin/deleteModifyActivites" style="text-decoration: none;">
                       Activities
                    </a>
                </p>
            </div>

        </div>

    </div>

    <br><br><br>

    <div class="container" style="text-align: center">
        <a class="button" href="/dashboard">User mode</a>
    </div>

</div><!-- End of container of the whole page -->
</body>
</html>
