<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dish Menu</title>
</head>
<body>
<h1 align="center">Dish Menu</h1>
<table border="1" CELLPADDING="30%" align="center" bordercolor="red">
    <tr>
        <th>Position</th>
        <th>Dish</th>
        <th>Price (in USD)</th>
    </tr>
    <c:forEach var="item" items="${foodList}">
        <tr>
            <td>${item.id}</td>
            <td>${item.item}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
