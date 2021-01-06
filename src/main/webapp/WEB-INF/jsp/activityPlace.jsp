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
    <title>Place of your activity</title>
</head>
<body>

<form:form action="/saveActivity" modelAttribute="myPlace">

    <label>
        List of places
        <form:select path="idLieu">
            <form:options items="${lieux}" itemValue="idLieu" itemLabel="denomination" />
        </form:select>
    </label>

    Valider le lieu : <input type="submit" name="submit" value="✓"/>

</form:form>

<form method="POST" action="/addPlace">

    <label>
        Name of the place
        <input type="text" name="nom"/>
    </label>

    <label>
        Address of the place
        <input type="text" name="adresse"/>
    </label>

    <input type="submit" name="submit" value="+"/>

</form>



</body>
</html>
