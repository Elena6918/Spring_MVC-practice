<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-16
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<html>
<link href="${pageContext.request.contextPath}/resources/css/work.css" rel="stylesheet">
<head>
    <title>Work Display</title>
</head>
<body>
<ul>
    <li><a href="/private/main">Main</a></li>
    <li><a href="/private/composition">Composition</a></li>
    <li><a href="/private/worklist">Work List</a></li>
    <li><a href="/content/login">Log Out</a></li>
</ul>
<div class="row">
    <div class="col left">
        <h3>${workTitle}</h3>
        <hr>
        ${workContent}
        <div id="delete">
            <hr>
            <form action="/private/work/doDelete" method="post">
                <input type="hidden" name="workId" value="${workId}"/>
                <input type="submit" value="delete"/>
            </form>
        </div>

    </div>
    <div class="col right">
        <div id="image-box">
        <img src="<%=path%>${imagesPath}" id="viewImage" alt="missing image"/>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $("img").on("error", function() {
        $(this).hide();
    });
</script>