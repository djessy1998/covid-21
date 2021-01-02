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
    <title>Profile</title>
</head>
<body>
    <%
        User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    %>
    <sec:authorize access="isAuthenticated()">
        <h2> Information of <% out.println(principal.getUsername()); %> </h2>
        <br>
        <p> First name : <% out.println(principal.getFirstName()); %> </p>
        <p> Last name : <% out.println(principal.getLastName()); %> </p>
        <br>

        <a href="/modifyprofile"> Modifier </a>

    </sec:authorize>
</body>
</html>
