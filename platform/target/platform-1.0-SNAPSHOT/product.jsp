<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/8
  Time: 04:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品浏览</title>
</head>
<body>
<h1>商品列表</h1>
<c:if test="${not empty products}">
    <table border="1">
        <thead>
        <tr>
            <th>商品名称</th>
            <th>描述</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>
                    <form action="AddToCartServlet" method="post">
                        <input type="hidden" name="productId" value="${product.id}">
                        <button type="submit">添加至购物车</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${empty products}">
    <p>没有商品。</p>
</c:if>

<br>
<a href="user.jsp">返回用户界面</a>
</body>
</html>


