<%@page import="edu.iuh.fit.mvcservlet.model.Manufacturer"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kaiwinnn MVP</title>
</head>
<body>
<div style="display: flex;justify-items: center">
    <div>
        <div style="display: flex;margin-bottom: 1rem;justify-content: space-between;">
            <h4 style="margin: 0;padding: 0">Danh sach Manu</h4>
            <a href="manager?action=add-manager">Them Manager</a>
        </div>
        <table border ="1">
            <tr>
                <th>id manu</th>
                <th>name</th>
            </tr>
            <%
                List<Manufacturer> ds = (List<Manufacturer>) session.getAttribute("managers");
            %>
            <%
                for(Manufacturer item: ds){
            %>
            <tr>
                <td><%=item.getManid()%></td>
                <td><%=item.getName()%></td>
                <td><a href="manager?action=delete&id=<%=item.getManid()%>">delete</a></td>
                <td><a href="manager?action=update&id=<%=item.getManid()%>">update</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>

</body>
</html>
