<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2024
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body>
    <div class="container">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Add Product
        </button> <br/><br/>
        <table class="table">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>
                            <c:out value="${product.id}"/>
                        </td>
                        <td>
                            <c:out value="${product.name}"/>
                        </td>
                        <td>
                            <c:out value="${product.description}"/>
                        </td>
                        <td>
                            <c:out value="${product.imgPath}"/>
                        </td>
                        <td>
                            <a href=""><i style="color: forestgreen" class="bi bi-plus-circle"></i></a>
                            <a href=""><i class="bi bi-pencil-square"></i></a>
                            <a href="http://localhost:8080/week4_final-1.0-SNAPSHOT/api/products/delete?id=<c:out value='${product.id}'/>"><i style="color: tomato" class="bi bi-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Modal Add Product -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title fs-5" id="exampleModalLabel" style="text-align: center">Add Product</h3>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="controllers" method="get">
                            <input type="hidden" name="action" value="add">
                            <div class="modal-body">
                                <div class="container col-md-8 col-md-offset-3">
                                    <div class="form-group">
                                        <button type="reset" class="btn btn-warning">Reset Value Input</button>
                                    </div>
                                    <div class="form-group">
                                        <label>Product Name:</label> <input type="text" class="form-control" placeholder="Product Name" name="name" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Description:</label> <input type="text" class="form-control" placeholder="Description" name="desc" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Image Path:</label> <input type="text" class="form-control" placeholder="Image Path" name="imgPath" required>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>
