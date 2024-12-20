<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/7/2024
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="./common/header.jsp"></jsp:include>
    <div class="container">
        <h2 style="text-align: center">Account Management Dashboard</h2>

        <table class="table">
            <thead>
            <tr>
                <th>Account ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Roles</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <!-- Loop qua các user -->
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>
                        <c:out value="${account.accountId}"/>
                    </td>
                    <td>
                        <c:out value="${account.fullName}"/>
                    </td>
                    <td>
                        <c:out value="${account.email}"/>
                    </td>
                    <td>
    <%--                    <c:choose>--%>
    <%--                        <c:when test="${not empty roles}">--%>
    <%--                            <c:forEach var="role" items="${roles}">--%>
    <%--                                ${role}<br/>--%>
    <%--                            </c:forEach>--%>
    <%--                        </c:when>--%>
    <%--                        <c:otherwise>--%>
    <%--                            No roles found.--%>
    <%--                        </c:otherwise>--%>
    <%--                    </c:choose>--%>
                        User
                    </td>

                    <td>
                        <button class="btn btn-primary">Role</button>
                        <button class="btn btn-warning">Edit</button>
                        <button class="btn btn-danger">Delete</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>
