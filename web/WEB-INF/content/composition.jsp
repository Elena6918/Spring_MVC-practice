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
<%--<div id="input-box">--%>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="picture">
        <input type="submit" value="upload">
    </form>
    <form action="/save" method="post">
        <textarea style="resize: none" id="content-box" name="textarea"  placeholder="write something here..."></textarea>
        <input type="submit" id="post-btn" value="save"/>
    </form>
<%--</div>--%>
</body>
</html>