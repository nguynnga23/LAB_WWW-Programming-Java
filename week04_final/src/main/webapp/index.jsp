<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2024
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>
        <form action="controllers" method="get">
            <input type="hidden" name="action" value="list"> <br/>
            <button type="submit" class="btn btn-success">View list product</button>
        </form>
    </body>
</html>
