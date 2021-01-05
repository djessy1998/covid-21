<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form method="POST" action="/addActivity">

    <label>
        List of places
        <select name="lieuOption">
            <c:forEach var="lieu" items="${lieux}" varStatus="row">
                <option>${lieu.denomination}</option>
            </c:forEach>
        </select>
    </label>

    Valider le lieu : <input type="submit" name="submit" value="✓"/>

</form>

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
