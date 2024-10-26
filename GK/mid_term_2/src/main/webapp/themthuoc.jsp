<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/23/2024
  Time: 5:34 PM
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
<jsp:include page="./header.jsp"></jsp:include>

<div>
    <div style="width: 60%">
        <c:if test="${thuoc == null}">
            <h3 style="align-items: center" class="text-justify font-weight-bold text-primary">Thêm thuốc mới</h3>
            <form action="thuoc?action=addThuoc" method="post">
                <div class="form-group">
                    <input class="form-control" name="tenThuoc" placeholder="Nhập tên thuốc"/>
                </div>
                <div class="form-group">
                    <input class="form-control" name="gia" placeholder="Nhập giá thuốc"/>
                </div>
                <div class="form-group">
                    <input class="form-control" name="namSX" placeholder="Nhập năm sản xuất"/>
                </div>
                <div class="form-group">
                    <select class="form-control" name="loaiThuoc">
                        <option class="form-control">Chọn loại thuốc</option>
                        <c:forEach var="loai" items="${dsLoaiThuoc}">
                            <option class="form-control" value="${loai.maLoai}">${loai.tenLoai}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input class="form-control btn-primary" type="submit">
                </div>
            </form>
        </c:if>

        <c:if test="${thuoc != null}">
            <h3 style="align-items: center" class="text-justify font-weight-bold text-primary">Cập nhật thuốc</h3>
            <form action="thuoc" method="post">
                <input type="hidden" name="action" value="updateThuoc"/>
                <div class="form-group">
                    <label>Mã thuốc</label>
                    <input class="form-control" name="maThuoc" value="${thuoc.maThuoc}"/>
                </div>

                <div class="form-group">
                    <label>Tên thuốc</label>
                    <input class="form-control" name="tenThuoc" value="${thuoc.tenThuoc}"/>
                </div>
                <div class="form-group">
                    <label>Giá</label>
                    <input class="form-control" name="gia" value="${thuoc.gia}"/>
                </div>
                <div class="form-group">
                    <label>Năm sản xuất</label>
                    <input class="form-control" name="nameSX" value="${thuoc.nameSX}"/>
                </div>
                <div class="form-group">
                    <label>Loại thuốc</label>
                    <select class="form-control" name="loaiThuoc">
                        <c:forEach var="loai" items="${dsLoaiThuoc}">
                            <option class="form-control" value="${loai.maLoai}"
                                    <c:if test="${loai.maLoai == thuoc.loaiThuoc.maLoai}">
                                        selected="selected"
                                    </c:if>>
                                    ${loai.tenLoai}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input class="form-control btn btn-primary" type="submit">
                </div>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
