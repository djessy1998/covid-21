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
    <title>Modify</title>
</head>
<body>

<h1>Change your information</h1>

<%
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
%>

<sec:authorize access="isAuthenticated()">

<form method="POST" action="/modifyprofile/saveUsername">
    Username : <input type="text" name="username" value="<% out.println(principal.getUsername()); %>"/>
    <input type="submit" name="submit" value="✓"/>
</form>

<form method="POST" action="/modifyprofile/saveFirstName">
    First name : <input type="text" name="firstname" value="<% out.println(principal.getFirstName()); %>"/>
<input type="submit" name="submit" value="✓"/>
</form>

<form method="POST" action="/modifyprofile/saveLastName">
    Last name : <input type="text" name="lastname" value="<% out.println(principal.getLastName()); %>"/>
<input type="submit" name="submit" value="✓"/>
</form>

    <hr>

    <form method="POST" action="/modifyprofile/savePassword">
        Change password : <br>
        <input type="text" name="password" />
        <input type="text" name="password-check"/>
        <input type="submit" name="submit" value="✓"/>
    </form>


    <a href="/profile">Go back</a>


</sec:authorize>

</body>
</html>
