<%--
  Created by IntelliJ IDEA.
  User: diana
  Date: 08/01/2021
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid : Help</title>

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

    <h6>Qu'est-ce que Covid ?</h6>
    <p>Covid est un site web développé par deux élèves de M1 de la FST de Nancy.</p>
    <p>Les utilisateurs peuvent déclarer se rendre à différentes activités.
       Ils peuvent aussi déclarés avoir été testés positifs : les personnes qui se sont rendus aux mêmes lieux,
    activités pendant la même tranche horaire recevront une notification.</p>
    <br>
    <p>
        <b>Frameworks utilisés :</b> SpringBoot, Thymeleaf, Skeleton (css)
    </p>
    <p><b>Source des images : </b> Freepik</p>
    <br>
    <br>
    <p>Djessy ROSSI, Diana POP, https://github.com/djessy1998/covid-21</p>
    <p>Université de Lorraine (2020-2021), Faculté des sciences et de technologies de Nancy (FST)</p>

</div> <!-- Fin container de toute la page -->
</body>
</html>
