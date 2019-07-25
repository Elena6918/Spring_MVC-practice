<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-05
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Board</title>
</head>
<body>
<ul>
    <li><a href="/private/composition">Composition</a></li>
    <li><a href="/private/worklist">Work list</a></li>
    <li><a href="/login">Log Out</a></li>
</ul>
<br>
${user.userName},welcome to Discussion Board，your current credit is ${user.credits};
<br>

<br>

</body>
</html>
