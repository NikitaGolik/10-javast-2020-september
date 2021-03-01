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

Upload File:
<form action="${pageContext.request.contextPath}/load" method="post" enctype="multipart/form-data">
  <input type="file" name="data"/> <br>
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