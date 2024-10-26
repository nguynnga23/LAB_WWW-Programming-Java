<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/25/2024
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<jsp:include page="common/header-after-login.jsp"></jsp:include>
<div>
    <h2>User Login Form</h2>
    <form action="/todos?action=update" method="post">
        <input type="text" placeholder="First Name" name="firstName" required>
        <input type="text" placeholder="Last Name" name="lastName" required>
        <input type="text" placeholder="Username" name="username" required>
        <input type="text" placeholder="Password" name="password" required>
        <input type="submit" value="Register" required>
    </form>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
