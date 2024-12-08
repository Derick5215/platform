<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/9
  Time: 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>管理员界面</title>
</head>
<body>
<h2>欢迎管理员</h2>
<ul>
    <li><a href="UserManagementServlet">用户管理</a></li>
    <li><a href="ProductManagementServlet">商品管理</a></li>
    <li><a href="OrderManagementServlet">订单浏览</a></li>
    <li><a href="LogoutServlet">注销</a></li>
</ul>
</body>
</html>
