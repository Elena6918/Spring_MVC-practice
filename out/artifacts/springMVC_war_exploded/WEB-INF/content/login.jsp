<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-05
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<body>
<div id="login-box">
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <form action="<c:url value="/loginCheck"/>" method="post">
        username：
        <input type="text" name="userName">
        <br>
        password：
        <input type="password" name="password">
        <br>
        <input type="submit" value="submit"/>
        <input type="reset" value="reset"/>
    </form>
    <form action="<c:url value="/register"/>" method="post">
        Not registered user? click here:
        <input type="submit" value="register"/>
    </form>
</div>

</body>
</html>
