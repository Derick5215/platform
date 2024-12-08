<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/9
  Time: 01:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>用户管理</title>
</head>
<body>
<h2>用户管理</h2>

<h3>用户列表</h3>
<table border="1">
    <tr>
        <th>用户名</th>
        <th>邮箱</th>
        <th>角色</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>
                <a href="DeleteUserServlet?id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>添加新用户</h3>
<form action="UserManagementServlet" method="POST">
    <label for="username">用户名:</label><br>
    <input type="text" name="username" id="username" required><br>
    <label for="password">密码:</label><br>
    <input type="password" name="password" id="password" required><br>
    <label for="email">邮箱:</label><br>
    <input type="email" name="email" id="email" required><br>
    <label for="role">角色:</label><br>
    <select name="role" id="role">
        <option value="admin">管理员</option>
        <option value="user">普通用户</option>
    </select><br>
    <input type="submit" value="添加用户">
</form>

<br>
<a href="admin.jsp">返回管理员界面</a>
</body>
</html>



