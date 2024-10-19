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
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        .container{
            width: 50%;
        }

    </style>
</head>
<body>
    <div class="container col-md-8 col-md-offset-3">
        <h2>Add product</h2>
        <form action="controllers" method="get">
            <input type="hidden" name="action" value="add"> <br/>
            <div class="form-group">
                <label>Product Name:</label> <input type="text" class="form-control" placeholder="Product Name" name="name" required>
            </div>

            <div class="form-group">
                <label>Description:</label> <input type="text" class="form-control" placeholder="Description" name="desc" required>
            </div>

            <div class="form-group">
                <label>Image Path:</label> <input type="text" class="form-control" placeholder="Image Path" name="imgPath" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-warning">Reset</button>
            </div>
        </form>
        <form action="controllers" method="get">
            <input type="hidden" name="action" value="list"> <br/>
            <button type="submit" class="btn btn-success">View list product</button>
        </form>
    </div>
</body>
</html>
