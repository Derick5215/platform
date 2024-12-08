<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/9
  Time: 02:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单管理</title>
</head>
<body>
<h2>订单管理</h2>

<table border="1">
    <thead>
    <tr>
        <th>订单ID</th>
        <th>用户ID</th>
        <th>商品ID</th>
        <th>数量</th>
        <th>总价</th>
        <th>订单状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.user_id}</td>
            <td>${order.product_id}</td>
            <td>${order.quantity}</td>
            <td>${order.total_price}</td>
            <td>${order.order_rate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="admin.jsp">返回管理员界面</a>

</body>
</html>
