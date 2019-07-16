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

    <div class="col left">
        <form action="/save" method="post">
            Title: <input type="text" name="title" id="title-box">

            <hr>

            <textarea rows="30" cols="100" name="content" placeholder="write something here..."
                      style="resize: none"></textarea>
            <br>
            <input type="submit" id="post-btn" value="save"/>
        </form>
    </div>

    <div class="col right">
        <h2>Column</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies,
            eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat,
            purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque
            tortor sed accumsan convallis.
            A placeholder image
            A preview image function here.
        </p>
        <form action="/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="picture">
            <input type="submit" value="upload">
        </form>
    </div>

</body>
</html>