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
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath", basePath);
%>
<html>
<link href="${pageContext.request.contextPath}/resources/css/work.css" rel="stylesheet">
<head>
    <title>Work Display</title>
</head>
<body>
<div class="row">
    <div class="col left">
        <h3>${workTitle}</h3>
        <hr>
        ${workContent}
    </div>
    <div class="col right">
        <img src="${basePath}${imagesPath}" id="previewImage" alt="missing image"/>
    </div>
</div>
</body>
</html>