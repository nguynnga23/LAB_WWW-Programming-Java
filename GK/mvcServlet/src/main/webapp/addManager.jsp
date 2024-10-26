<%@ page import="java.util.List" %>
<%@ page import="edu.iuh.fit.mvcservlet.model.Manufacturer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
//    List<Manufacturer> manufacturers = (List<Manufacturer>) session.getAttribute("manufactures");
    Manufacturer manager = (Manufacturer) request.getAttribute("managers");
%>

<%
    if(manager == null){
%>
<div style="padding: 2rem 2rem;">
    <label for="add-manager" style="font-weight: bold">Add Mangager</label>
    <form id="add-manager" action="manager?action=add-manager" method="post">
        <input type="text" id="id" name="id" placeholder="input id ...">
        <input type="text" id="name" name="name" placeholder="input name ...">

        <input type="submit" value="submit">
    </form>
    <br/>
    <span style="color: red">${errorPrice}</span>
</div>
<%
    }
%>


<%
    if(manager != null){
%>
<div style="padding: 2rem 2rem;">
    <label for="form-update" style="font-weight: bold">Update manager where id = <%=manager.getManid()%></label>
    <form id="form-update" action="manager?action=update&id=<%=manager.getManid()%>" method="post">
        <input type="text" name="idkhacnull" disabled value="<%=manager.getManid()%>">
        <input type="text" name="name" value="<%=manager.getName()%>">
        <input type="submit" value="submit">
    </form>
</div>
<%
    }
%>

</body>
</html>
