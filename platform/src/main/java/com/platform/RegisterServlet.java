package com.platform;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取注册表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // 校验非空
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            request.setAttribute("error", "未填写所有内容！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 插入数据库
        Connection conn;
        PreparedStatement stmt;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            int result = stmt.executeUpdate();

            // 判断是否插入成功
            if (result > 0) {
                // 插入成功，重定向到登录页面并传递成功消息
                response.sendRedirect("login.jsp?message=" + URLEncoder.encode("注册成功！请登录", "UTF-8"));
            } else {
                // 插入失败，提示错误
                request.setAttribute("error", "注册失败，请重试！");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "数据库错误：请稍后重试");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}




