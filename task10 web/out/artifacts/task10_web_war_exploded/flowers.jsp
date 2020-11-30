<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikitos
  Date: 30.11.2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flowers list</title>
</head>
<body>
<a href="/hello">home</a>
<table>
    <c:forEach var="flower" items="${listFlowers}" varStatus="status">
    <tr>
        <td><c:out value="${ flower.leaf_color }" /></td>
        <td><c:out value="${ flower.name }" /></td>
        <td><c:out value="${ flower.origin }" /></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
