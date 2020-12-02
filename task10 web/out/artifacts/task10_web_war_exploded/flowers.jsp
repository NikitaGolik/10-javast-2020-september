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
<a href="index.jsp">home</a>
<table class="center">
    <th>FlowerName</th>
    <th>Origin</th>
    <th>ID</th>
    <th>SOIL</th>
    <th>StemColor</th>
    <th>LeafColor</th>
    <th>Average_size</th>
    <th>Temperature</th>
    <th>Light_requiring</th>
    <th>Watering</th>
    <th>Multiplying</th>

    <c:forEach items="${flowerList}" var="item">
        <tr>
            <td><c:out value="${item.name}" /></td>
            <td><c:out value="${item.origin}" /></td>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.soil}" /></td>
            <td><c:out value="${item.stem_color}" /></td>
            <td><c:out value="${item.leaf_color}" /></td>
            <td><c:out value="${item.average_plant_size}" /></td>
            <td><c:out value="${item.temperature}" /></td>
            <td><c:out value="${item.light_requiring}" /></td>
            <td><c:out value="${item.watering}" /></td>
            <td><c:out value="${item.multiplying}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
