<%--
  Created by IntelliJ IDEA.
  User: djessyrossi
  Date: 01/12/2020
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid : Login</title>


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
                <a href="/login" style="text-decoration: none; text-decoration-color: #bbbbbb" >
                    <h4> </h4>
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

    <div class="container" style="text-align: center;" >
    <div class="container">
     <div class="row">
            <div class="twelve columns">
               <h6>Welcome !</h6>
           </div>
     </div>
    </div>

    <div class="container" >
        <form method="POST" action="/login">


        <div class="row">
            <div class="twelve columns">
                <label>Username :</label> <input type="text" name="username" />
            </div>
         </div>

            <div class="row">
                <div class="twelve columns">
                    <label>Password  :</label>  <input type="password" name="password" />
                </div>
            </div>

            <input class="button-primary" type="submit" name="submit"/>
        </form>
    </div>

    </div>

    <div style="text-align: center;">
        <p>No account ? <a href="/register" >Register</a></p>
    </div>

</div> <!-- End of container for the whole page -->

</body>
</html>
