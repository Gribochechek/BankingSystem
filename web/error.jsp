<%--
  Created by IntelliJ IDEA.
  User: Danila
  Date: 14.08.2018
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'eng'}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html lang="${language}">
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>Access error</title>
</head>
<body>
<p class="text-danger text-center font-weight-bold">
    <c:out value="${sessionScope.role}"/>
</p>
<div class="container">
    <p class="text-danger font-weight-bold">
        Access error
    </p>
</div>
</body>
</html>
