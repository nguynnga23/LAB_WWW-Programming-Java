<%@ page import="com.example.entities.Thuoc" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<%
    response.sendRedirect("thuoc?action=dsthuoc");
%>
</body>
</html>