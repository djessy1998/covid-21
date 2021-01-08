<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.covid.covid.model.User" %><%--
  Created by IntelliJ IDEA.
  User: diana
  Date: 02/01/2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid - Modify my profile</title>

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
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

    <div class="container" style="align-content: center">
        <h6>What to change ?</h6>
    </div>

    <div class="container">
        <div class="row">
            <!-- username, first name, last name -->
            <div class="five columns">
                <!-- Username form -->
                <form method="POST" action="/modifyprofile/saveUsername">
                    <label>Username :</label><input type="text" name="username" value="<% out.println(principal.getUsername()); %>"/>
                    <input  class="button-primary"
                            type="submit"
                            name="submit"
                            value="✓"/>
                </form>

                <!-- First name form -->
                <form method="POST" action="/modifyprofile/saveFirstName">
                    <label>First name :</label> <input type="text" name="firstname" value="<% out.println(principal.getFirstName()); %>"/>
                    <input  class="button-primary"
                            type="submit"
                            name="submit"
                            value="✓"/>
                </form>

                <!-- Last name form -->
                <form method="POST" action="/modifyprofile/saveLastName">
                    <label>Last name :</label> <input type="text" name="lastname" value="<% out.println(principal.getLastName()); %>"/>
                    <input class="button-primary"
                           type="submit"
                           name="submit"
                           value="✓"/>
                </form>

            </div><!-- end of six columns 1-->

            <div class="seven columns" style="align-content: center; text-align: center">
                <form method="POST" action="/modifyprofile/saveImage" enctype="multipart/form-data">
                    <p><label>Image :</label> </p><input type="File" name="image" />
                    <input
                            class="button-primary"
                            type="submit"
                            name="submit"
                            value="✓"/>
                </form>


                <p> Votre image est actuellement : </p>

                <img    height="200px"
                        width="200px"
                        alt="image_profil"
                        src="data:image/jpeg;base64,${image}" />


            </div><!-- end of six columns 2-->
        </div><!-- end of row-->
    </div>

    <hr>

    <div class="container" >
        <div class="row">
            <h6>Change password :</h6>
        </div>
        <div class="row" style="text-align: center">
            <form method="POST" action="/modifyprofile/savePassword">

                <p>New password :</p>
                <input type="text" name="password" />
                <p>Confirmation :</p>
                <input type="text" name="password-check"/>
                <br>
                <input  class="button-primary"
                        type="submit" name="submit" value="✓"/>
            </form>
        </div>

    </div>


    <hr>

    <div class="container" style="text-align: center">
        <a class="button" href="/profile">Go back</a>
    </div>



</div> <!-- Fin du container de toute la page -->

</sec:authorize>
</body>
</html>
