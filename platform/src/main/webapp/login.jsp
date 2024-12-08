<%--
  Created by IntelliJ IDEA.
  User: 26521
  Date: 2024/12/8
  Time: 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
</head>
<body>
<h2>登录</h2>

<!-- 显示注册成功消息 -->
<c:if test="${not empty param.message}">
    <p style="color: green;">${param.message}</p>
</c:if>

<form action="LoginServlet" method="post">
    <div>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <button type="submit">登录</button>
    </div>
</form>

<br>
<a href="register.jsp">没有账号？去注册</a>
</body>
</html>

