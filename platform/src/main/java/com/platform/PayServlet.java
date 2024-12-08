package com.platform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");

        try (Connection conn = DBUtil.getConnection()) {
            // 先查询购物车中的商品
            String selectSql = "SELECT c.product_id, p.name, p.price, c.quantity " +
                    "FROM cart c " +
                    "JOIN products p ON c.product_id = p.product_id " +
                    "WHERE c.users_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectSql)) {
                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();

                // 将购物车中的每个商品插入到订单表中
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    BigDecimal price = rs.getBigDecimal("price");
                    int quantity = rs.getInt("quantity");
                    BigDecimal totalPrice = price.multiply(new BigDecimal(quantity));

                    // 插入订单表
                    String insertSql = "INSERT INTO orders (user_id, product_id, quantity, total_price, order_rate) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setInt(1, userId);
                        insertStmt.setInt(2, productId);
                        insertStmt.setInt(3, quantity);
                        insertStmt.setBigDecimal(4, totalPrice);
                        insertStmt.setString(5, "Paid");
                        insertStmt.executeUpdate();
                    }
                }

                // 清空购物车
                String deleteSql = "DELETE FROM cart WHERE users_id = ?";
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                    deleteStmt.setInt(1, userId);
                    deleteStmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 跳转到订单界面
        response.sendRedirect("OrderServlet");
    }
}


