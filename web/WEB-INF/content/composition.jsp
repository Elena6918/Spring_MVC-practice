<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-12
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="${pageContext.request.contextPath}/resources/css/composition.css" rel="stylesheet">
<head>
    <title>Composition Page</title>
</head>
<body>
<c:if test="${not empty info}">
    <div class="info">${info}</div>
</c:if>
<div id="input-box">
    <textarea style="resize: none" id="content-box" rows="5" cols="30" placeholder="write something here..."></textarea>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="picture">
        <input type="submit" value="upload">
        <input type="button" id="post-btn" value="submit work"/>
    </form>
</div>
</body>
</html>
