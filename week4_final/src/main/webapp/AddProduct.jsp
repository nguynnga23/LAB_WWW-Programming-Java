<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2024
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
    <h2>Add product</h2>
    <form action="controllers" method="get">
        <input type="hidden" name="action" value="add"><br/>
        <input name="name"/><br/>
        <input name="desc"/><br/>
        <input name="imgPath"/><br/>
        <input type="submit" value="Insert"/><br/>
        <input type="reset"/><br/>
    </form>
    <a href="ListProduct.jsp">View list product</a>
</body>
</html>
