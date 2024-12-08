package com.platform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 非空校验
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "请输入用户名和密码！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        try {
            conn = DBUtil.getConnection();
            // 查询数据库中的用户名、密码和角色
            String sql = "SELECT username, password, role FROM users WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            // 检查用户名是否存在
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                String role = rs.getString("role");

                // 检查密码是否匹配
                if (storedPassword.equals(password)) {
                    // 密码正确，进行角色判断并跳转
                    if ("admin".equals(role)) {
                        // 如果是管理员，跳转到管理员界面
                        response.sendRedirect("admin.jsp");
                    } else if ("user".equals(role)) {
                        // 如果是普通用户，跳转到用户界面
                        response.sendRedirect("user.jsp");
                    } else {
                        // 如果角色不符合要求，可以返回错误（不太常见）
                        request.setAttribute("error", "无效的角色！");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } else {
                    // 密码错误
                    request.setAttribute("error", "密码错误！");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // 用户名错误
                request.setAttribute("error", "用户名错误！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "数据库错误，请稍后再试！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}






