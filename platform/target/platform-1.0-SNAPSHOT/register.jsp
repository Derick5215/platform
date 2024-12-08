<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/8
  Time: 01:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
</head>
<body>
<h2>注册</h2>

<!-- 显示错误信息 -->
<c:if test="${not empty requestScope.error}">
    <p style="color: red;">${requestScope.error}</p>
</c:if>

<form action="RegisterServlet" method="post">
    <div>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="email">邮箱:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <button type="submit">注册</button>
    </div>
</form>

<br>
<a href="login.jsp">已有账号？去登录</a>
</body>
</html>




