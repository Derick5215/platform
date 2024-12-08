package com.platform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId"); // 获取当前用户 ID
        int productId = Integer.parseInt(request.getParameter("productId")); // 获取商品 ID

        try (Connection connection = DBUtil.getConnection()) {
            // 检查购物车中是否已有该商品
            String checkSql = "SELECT quantity FROM cart WHERE users_id = ? AND product_id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setInt(1, userId);
            checkStmt.setInt(2, productId);
            java.sql.ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // 如果商品已存在，则增加数量
                String updateSql = "UPDATE cart SET quantity = quantity + 1 WHERE users_id = ? AND product_id = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                updateStmt.setInt(1, userId);
                updateStmt.setInt(2, productId);
                updateStmt.executeUpdate();
            } else {
                // 如果商品不存在，则插入新的记录
                String insertSql = "INSERT INTO cart (users_id, product_id, quantity) VALUES (?, ?, 1)";
                PreparedStatement insertStmt = connection.prepareStatement(insertSql);
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, productId);
                insertStmt.executeUpdate();
            }
            request.setAttribute("message", "已添加至购物车！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加至购物车失败：" + e.getMessage());
        }

        // 返回商品展示界面并显示消息
        request.getRequestDispatcher("ProductServlet").forward(request, response);
    }
}
