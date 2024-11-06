<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/23/2024
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <style>
        html {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Verdana;
        }

        .wrapper {
            display: flex;
            background-color: tomato;
            height: 50px;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }

        h2 {
            text-align: center;
            color: white;
            font-size: 20px;
            font-family: Verdana;
        }

        .nav-list a {
            width: 30%;
            height: 40px;
            color: white;
            font-size: 20px;
            font-weight: 700;
            text-transform: uppercase;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <%--        <h2>21130791 - Nguyễn Thị Nga</h2><br/>--%>
    <div class="nav-list">
        <a href="loaithuoc?action=dsloaithuoc&id=">Danh sách các loại thuốc</a> <span style="color: white">  |  </span>
        <a href="thuoc?action=dsthuoc">Danh sách thuốc</a><span style="color: white">  |  </span>
        <a href="thuoc?action=add">Thêm thuốc mới</a>
    </div>
</div>

</body>
</html>
