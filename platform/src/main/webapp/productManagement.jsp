<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/9
  Time: 01:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>商品管理</title>
</head>
<body>
<h2>商品管理</h2>

<!-- 商品列表 -->
<h3>商品列表</h3>
<table border="1">
    <tr>
        <th>商品名称</th>
        <th>价格</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <a href="DeleteProductServlet?id=${product.id}">删除</a> |
                <a href="EditProductServlet?id=${product.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- 添加商品 -->
<h3>添加新商品</h3>
<form action="AddProductServlet" method="POST">
    <label for="name">商品名称:</label><br>
    <input type="text" name="name" id="name" required><br>
    <label for="price">价格:</label><br>
    <input type="text" name="price" id="price" required><br>
    <label for="description">描述:</label><br>
    <textarea name="description" id="description" required></textarea><br>
    <input type="submit" value="添加商品">
</form>

<br>
<a href="admin.jsp">返回管理员界面</a>
</body>
</html>

