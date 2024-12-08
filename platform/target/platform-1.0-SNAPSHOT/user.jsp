<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/8
  Time: 04:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户界面</title>
</head>
<body>
<h1>欢迎进入用户界面</h1>
<form action="ProductServlet" method="get">
    <button type="submit">浏览商品</button>
</form>
<form action="CartServlet" method="get">
    <button type="submit">购物车</button>
</form>
<form action="OrderServlet" method="get">
    <button type="submit">查看订单</button>
</form>
<form action="LogoutServlet" method="get">
    <button type="submit">注销</button>
</form>
</body>
</html>


