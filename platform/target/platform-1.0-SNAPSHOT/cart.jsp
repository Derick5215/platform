<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>购物车</title>
</head>
<body>
<h2>购物车</h2>

<c:if test="${not empty cartItems}">
    <table border="1">
        <tr>
            <th>商品名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>总价</th>
        </tr>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.productName}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>${item.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- 支付按钮 -->
    <form action="PayServlet" method="POST">
        <input type="submit" value="支付订单">
    </form>
</c:if>

<c:if test="${empty cartItems}">
    <p>购物车为空</p>
</c:if>

<a href="user.jsp">返回用户界面</a>
</body>
</html>
