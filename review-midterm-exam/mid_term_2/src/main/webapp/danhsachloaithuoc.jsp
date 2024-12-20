<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/23/2024
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách loại thuốc</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        html{
            font-family: Verdana;
        }

        .table-row {
            border-width: 1px;
            border-color: #333333;
            width: 100%;
        }

        th, td {
            border: 1px solid #333333; /* Đường viền cho các ô */
            padding: 12px; /* Khoảng cách bên trong ô */
        }
    </style>

</head>
<body>
<jsp:include page="./header.jsp"></jsp:include>

<div style="width: 60%">
    <div>
        <h3 style="align-items: center" class="text-justify font-weight-bold text-primary">Loại thuốc</h3>

        <form action="thuoc" method="get">
            <input type="hidden" name="action" value="dsThuoctheoten"/>
            <input type="text" placeholder="Tìm theo tên loại thuốc" name="tenThuoc">
            <input type="submit" value="Lọc">
        </form>
        <table style="width: 100%">
            <tr class="table-header">
                <th>Mã loại thuốc</th>
                <th>Tên loại thuốc</th>
                <th>Action</th>
            </tr>

            <c:forEach var="loaiThuoc" items="${dsLoaiThuoc}">
                <tr class="table-row">
                    <td>${loaiThuoc.maLoai}</td>
                    <td>${loaiThuoc.tenLoai}</td>
                    <td>
                        <a href="thuoc?action=delete&id=${loaiThuoc.maLoai}">delete</a>
                        <a href="thuoc?action=update&id=${loaiThuoc.maLoai}">update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
