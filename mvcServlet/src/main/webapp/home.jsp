
<%@page import="edu.iuh.fit.mvcservlet.model.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <div style="display: flex;justify-items: center">
        <div>
           <div style="display: flex;margin-bottom: 1rem;justify-content: space-between;">
               <h4 style="margin: 0;padding: 0">Danh sach san pham</h4>
               <a href="product?action=add-product">Them san pham</a>
           </div>
           <table border="1">
               <tr>
                   <th>id</th>
                   <th>name</th>
                   <th>price</th>
                   <th>description</th>
                   <th>Manufuter</th>
                   <th colspan="2">Action</th>
               </tr>
               <%
                   List<Product> ds = (List<Product>) session.getAttribute("products");
               %>
               <%
                   for(Product item: ds){
               %>
               <tr>
                   <td><%=item.getId()%></td>
                   <td><%=item.getName()%></td>
                   <td><%=item.getPrice()%></td>
                   <td><%=item.getDescription()%></td>
                   <td><%=item.getManid().getName()%></td>
                   <td><a href="product?action=delete&id=<%=item.getId()%>">delete</a></td>
                   <td><a href="product?action=update&id=<%=item.getId()%>">update</a></td>
               </tr>
               <%
                   }
               %>
           </table>
       </div>
    </div>

</body>
</html>
