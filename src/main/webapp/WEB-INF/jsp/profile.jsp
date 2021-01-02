<%@ page import="com.covid.covid.model.User" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
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
    <title>Title</title>
</head>
<body>
    <%
        User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    %>
    <sec:authorize access="isAuthenticated()">
        Welcome Back, <% out.println(principal.getFirstName()); %>
    </sec:authorize>
</body>
</html>
