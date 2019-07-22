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
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath", basePath);
%>
<html>
<link href="${pageContext.request.contextPath}/resources/css/worklist.css" rel="stylesheet">

<head>
    <title>Worklist</title>
</head>
<body>
There is the list:
<div class="grid-container">
    <c:forEach items="${workList}" var="data">
        <div>
            <a href=${basePath}work?workId=${data.workId}>
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