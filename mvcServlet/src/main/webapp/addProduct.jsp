<%@ page import="java.util.List" %>
<%@ page import="edu.iuh.fit.mvcservlet.model.Manufacturer" %>
<%@ page import="edu.iuh.fit.mvcservlet.model.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
    List<Manufacturer> manufacturers = (List<Manufacturer>) session.getAttribute("manufactures");
    Product product = (Product) request.getAttribute("product");
%>

<%
    if(product == null){
%>
<div style="padding: 2rem 2rem;">
    <label for="add-product" style="font-weight: bold">Add product</label>
    <form id="add-product" action="product?action=add-product" method="post">
        <input type="text" id="name" name="name" placeholder="input name ...">
        <input type="text" id="price" name="price" placeholder="input price ...">
        <input type="text" id="description" name="description" placeholder="input description ...">
        <select name="manufacture">

            <%
                for (Manufacturer mn:manufacturers){
            %>
                <option><%=mn.getName()%></option>
            <%
                }
            %>
        </select>

        <input type="submit" value="submit">
    </form>
    <br/>
    <span style="color: red">${errorPrice}</span>
</div>
<%
    }
%>


<%
    if(product != null){
%>
<div style="padding: 2rem 2rem;">
    <label for="form-update" style="font-weight: bold">Update product where id = <%=product.getId()%></label>
    <form id="form-update" action="product?action=update&id=<%=product.getId()%>" method="post">
        <input type="text" name="id" disabled value="<%=product.getId()%>">
        <input type="text" name="name" value="<%=product.getName()%>">
        <input type="text" name="price" value="<%=product.getPrice()%>">
        <input type="text" name="description" value="<%=product.getDescription()%>">
        <select name="manufacture">
            <%
                for (Manufacturer mn:manufacturers){
            %>
            <option><%=mn.getName()%></option>
            <%
                }
            %>
        </select>
        <input type="submit" value="submit">
    </form>
</div>
<%
    }
%>

</body>
</html>
