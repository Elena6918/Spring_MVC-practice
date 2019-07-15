<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-10
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<head>
    <title>Register Page</title>
</head>
<body>
<form action="<c:url value="/registering"/>" method="post">
    <div id="login-box">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty info}">
            <div class="info">${info}</div>
        </c:if>
        username
        <input type="text" id="userName" name="username">
        <br>
        password
        <input type="password" id="password" name="password">
        <br>
        <input id="submit" type="submit" value="register">
        <br>
        <a href="/login">back to login page</a>

        <%--            <form action="<c:url value="/login"/>" method="post">--%>
        <%--                <input type="submit" value="back to login"/>--%>
        <%--            </form>--%>
    </div>
</form>

</body>
</html>
