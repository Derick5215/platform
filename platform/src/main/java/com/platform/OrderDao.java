package com.platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class OrderDao {

        public List<Order> getAllOrders() {
            List<Order> orderList = new ArrayList<>();
            String sql = "SELECT * FROM orders";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Order order = new Order(
                            rs.getInt("id"),
                            rs.getString("productName"),
                            rs.getInt("quantity"),
                            rs.getBigDecimal("total_price"),
                            rs.getString("order_rate")
                    );
                    orderList.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return orderList;
        }
    }
