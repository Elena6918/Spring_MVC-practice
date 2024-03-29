<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-12
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<%
    String path = request.getContextPath();
%>
<html>
<link href="${pageContext.request.contextPath}/resources/css/composition.css" rel="stylesheet">
<head>
    <title>Composition Page</title>
</head>
<body>
<c:if test="${not empty info}">
    <div class="info">${info}</div>
</c:if>
<ul>
    <li><a href="/private/main">Main</a></li>
    <li><a href="/private/worklist">Work List</a></li>
    <li><a href="/login">Log Out</a></li>
</ul>
<div class="row">
    <div class="col left">
        <form action="/private/composition/doSave" method="post">
            Title: <input type="text" name="title" id="title-box">
            <hr>
            <textarea rows="30" cols="100" name="content" placeholder="write something here..."></textarea>
            <hr>
            <input type="submit" id="post-btn" value="save"/>
            <input type="hidden" value="${imagesPath}" name="imagePath"/>
        </form>
        <form action="/private/worklist" method="post">
            <input type="submit" value="View Worklist">
        </form>
    </div>
    <div class="col right">
        <h2>Image</h2>
        Here is the image preview:
        <div id="image-box">
            <img src="<%=path%>${imagesPath}" id="previewImage"/>
        </div>
        <form action="/private/composition/doUpload" method="post" enctype="multipart/form-data">
            <input type="file" name="picture">
            <input type="submit" value="upload">
        </form>
    </div>
</div>
</body>
</html>
<script>
    $("img").on("error", function() {
        $(this).hide();
    });
</script>