<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<jsp:include page="common/header-after-login.jsp"></jsp:include>
<div>
    <h2>List of Todos</h2>
    <hr>
    <div><a href="/todos?action=new">Add Todo</a></div>
    <br>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Todo Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${listTodo}">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.title}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.isDone}</td>
                <td>${todo.title}</td>
                <td>
                    <a href="todos?action=edit&id=${todo.id}">Edit</a>
                    <a href="todos?action=delete&id=${todo.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
