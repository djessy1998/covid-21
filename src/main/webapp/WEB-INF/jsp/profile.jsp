<%@ page import="com.covid.covid.model.User" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.Url" %>
<%@ page import="com.covid.covid.controller.MapController" %>
<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/01/2021
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Covid - My profile</title>
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
    <%
        User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    %>

    <sec:authorize access="isAuthenticated()">

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


        <div class="container" style="text-align: center;">

            <h3>My information as <% out.println(principal.getUsername()); %></h3>



            <div class="row">
                <div class="six columns">
                    <p> <b> First name :</b> <% out.println(principal.getFirstName()); %> </p>
                    <p> <b>Last name :</b>  <% out.println(principal.getLastName()); %> </p>
                </div>

                <div class="six columns">
                    <img alt="image_profil"
                         height="200px"
                         width="200px"
                         src="data:image/jpeg;base64,<% out.println(principal.getImage()); %>"
                    />
                </div>
            </div>
        </div>

        <div class="container" style="text-align: center;">
            <a class="button button-primary" href="/modifyprofile">Modify</a>
            <br>
            <a class="button" href="/dashboard">Go back</a>
        </div>


    </div><!-- Fin du container de toute la page -->

    </sec:authorize>
</body>
</html>
