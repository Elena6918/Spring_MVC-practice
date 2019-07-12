<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 2019-07-10
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Uploaded File</title>
</head>
<body>
<h2>Submitted Files</h2>
<table>
    <%--    <c:forEach items="${picture}" var="picture">--%>
    <tr>
        <td>OriginalFileName:</td>
        <td>${picture.originalFilename}</td>
    </tr>
    <tr>
        <td>Type:</td>
        <td>${picture.contentType}</td>
    </tr>
    <%--    </c:forEach>--%>
</table>
</body>
</html>
