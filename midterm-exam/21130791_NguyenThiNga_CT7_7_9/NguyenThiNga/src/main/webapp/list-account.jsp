<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/26/2024
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div>
    <div>
        <form action="accounts" method="get">
            <select name="tieuchi">
                <option value="theotien">Tien</option>
                <option value="theoten">Ten</option>
            </select>
            <input type="hidden" name="action" value="filter-account"/>
            <input type="text" name="ten" placeholder="Input">
            <input type="submit" value="Submit"/>
        </form>
    </div>
    <table>
        <tr>
            <th style="border: 1px #000000 solid">Account Number</th>
            <th style="border: 1px #000000 solid">Owner Name</th>
            <th style="border: 1px #000000 solid">Card Number</th>
            <th style="border: 1px #000000 solid">Owner Address</th>
            <th style="border: 1px #000000 solid">Amount</th>
        </tr>
        <c:forEach var="account" items="${accounts}">
            <tr>
                <td style="border: 1px #000000 solid">${account.accountNumber}</td>
                <td style="border: 1px #000000 solid">${account.ownerName}</td>
                <td style="border: 1px #000000 solid">${account.cardNumber}</td>
                <td style="border: 1px #000000 solid">${account.ownerAddress}</td>
                <td style="border: 1px #000000 solid">${account.amount}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
