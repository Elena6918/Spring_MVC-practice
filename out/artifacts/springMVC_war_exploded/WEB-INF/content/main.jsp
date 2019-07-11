<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-05
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Discussion Board</title>
</head>
<body>
${user.userName},welcome to Discussion Board，your current credit is ${user.credits};
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="picture">
    <input type="submit" value="submit">
</form>
</body>
</html>
