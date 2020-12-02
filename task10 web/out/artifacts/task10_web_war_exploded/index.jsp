<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikitos
  Date: 30.11.2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>My PARSER</title>
</head>
<body>

Show localization and reading from file:
<form action="/read" method="post">
  <input type="hidden" name="path" value="data/data.txt">
  <input type="hidden" name="local" value="en">
  <input type="submit" name="button" value="en"/>
</form>

<form action="/read" method="post">
  <input type="hidden" name="path" value="data/data.txt">
  <input type="hidden" name="local" value="ru">
  <input type="submit" name="button" value="ru"/>
</form>

Upload File:
<form action="/load" method="post" enctype="multipart/form-data">
  <input type="file" name="description"/> <br>
  <button type="submit" name="upload">Upload</button>
</form>

Parse XML file:
<form action="${pageContext.request.contextPath}/parser" method="post">
  <input type="hidden" name="pathToXML" value="./data/flowers.xml">
  <input type="hidden" name="pathToXSD" value="./data/flowers.xsd">
  <button type="submit" name="button" value="DOM">DOMParser</button>
  <button type="submit" name="button" value="SAX">SAXParser</button>
  <button type="submit" name="button" value="STAX">StAXParser</button>
</form>

</body>
</html>