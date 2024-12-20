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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <jsp:include page="./common/header.jsp"></jsp:include>
    <div class="container">
        <h2 style="text-align: center">User Profile</h2>

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
            <tr>
                <td>
                    <%
                        String accountId = session.getAttribute("account").toString();
                    %>
                    <%=accountId%>
                </td>
                <td>
                    <%
                        String fullName = session.getAttribute("fullName").toString();
                    %>
                    <%=fullName%>
                </td>
                <td>
                    <%
                        String email = session.getAttribute("email").toString();
                    %>
                    <%=email%>
                </td>

                <td>
                    <c:choose>
                        <c:when test="${not empty roles}">
                            <c:forEach var="role" items="${roles}">
                                ${role}<br/>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            No roles found.
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <button class="btn btn-warning">Edit</button>
                    <button class="btn btn-danger">Delete</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>
