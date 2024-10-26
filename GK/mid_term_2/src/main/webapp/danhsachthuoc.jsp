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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Danh sách thuốc</title>
    <style>
        html {
            font-family: Verdana;
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
        <h3 style="align-items: center" class="text-justify font-weight-bold text-primary">Thuốc</h3>
        <form action="thuoc" method="get">
            <input type="hidden" name="action" value="dsthuoctheoloaithuoc"/>
            <select name="maLoai">
                <option>Chọn loại thuốc</option>
                <c:forEach var="loaiThuoc" items="${dsLoaiThuoc}">
                    <option value="${loaiThuoc.maLoai}">${loaiThuoc.tenLoai}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Lọc">
        </form>

        <form action="thuoc" method="get">
            <input type="hidden" name="action" value="dsThuoctheoten"/>
            <input type="text" placeholder="Tìm theo tên thuốc" name="tenThuoc">
            <input type="submit" value="Lọc">
        </form>

        <div>
            <table style="width: 100%">
                <tr class="table-header">
                    <th>Mã thuốc</th>
                    <th>Tên thuốc</th>
                    <th>Giá</th>
                    <th>Năm sản xuất</th>
                    <th>Loại thuốc</th>
                    <th style="column-span: 2">Action</th>
                </tr>


                <c:forEach var="thuoc" items="${dsThuoc}">
                    <tr class="table-row">
                        <td>${thuoc.maThuoc}</td>
                        <td>${thuoc.tenThuoc}</td>
                        <td>${thuoc.gia}</td>
                        <td>${thuoc.nameSX}</td>
                        <td>${thuoc.loaiThuoc.tenLoai}</td>
                        <td>
                            <form action="thuoc" method="post" style="display: inline">
                                <input type="hidden" name="action" value="deleteThuoc">
                                <input type="hidden" name="id" value="${thuoc.maThuoc}">
                                <button class="btn btn-danger" type="submit">Delete</button>
                            </form>

                            <form action="thuoc" method="get" style="display: inline">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="id" value="${thuoc.maThuoc}">
                                <button class="btn btn-success" type="submit">Update</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
