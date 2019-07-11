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
<head>
    <title>Register Page</title>
</head>
<body>
<h3>Register Page</h3>
<br>
<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty info}">
    <div class="info">${info}</div>
</c:if>
<form action="<c:url value="/registering"/>" method="post">
    <table>
        <tr>
            <td><label>username</label></td>
            <td><input type="text" id="userName" name="username"></td>
        </tr>
        <tr>
            <td><label>password</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="register"></td>
            <form action="<c:url value="/login"/>" method="post">
                <input type="submit" value="back to login"/>
            </form>

        </tr>
    </table>
</form>

</body>
</html>
<style>
    .error {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #a94442;
        background-color: #f2dede;
        border-color: #ebccd1;
    }

    .info {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #4185a9;
        background-color: #d6e6f2;
        border-color: #a8d0eb;
    }
</style>