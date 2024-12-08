<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/9
  Time: 01:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>订单</title>
</head>
<body>
<h2>订单详情</h2>

<c:if test="${not empty orders}">
  <table border="1">
    <tr>
      <th>商品名称</th>
      <th>数量</th>
      <th>总价</th>
      <th>订单状态</th>
    </tr>
    <c:forEach var="order" items="${orders}">
      <tr>
        <td>${order.productName}</td>
        <td>${order.quantity}</td>
        <td>${order.totalPrice}</td>
        <td>${order.orderRate}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<c:if test="${empty orders}">
  <p>没有订单记录</p>
</c:if>

<a href="user.jsp">返回用户界面</a>
</body>
</html>
