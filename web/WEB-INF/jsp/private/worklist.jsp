<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-18
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<link href="${pageContext.request.contextPath}/resources/css/worklist.css" rel="stylesheet">
<head>
    <title>Worklist</title>
</head>
<body>
<ul>
    <li><a href="/private/main">Main</a></li>
    <li><a href="/private/composition">Composition</a></li>
    <li><a href="/login">Log Out</a></li>
</ul>
<br>

There is the list:
<div class="grid-container">
    <c:forEach items="${workList}" var="data">
        <div>
            <a href=<%=path%>/private/work?workId=${data.workId}>
                ${data.workName}
            <br>
                ${data.creationTime}
            <br>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>

<script>
    $(function(){
        $("#nav-placeholder").load("navbar.jsp");
    });
</script>