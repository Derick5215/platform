package com.platform;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/platform?useUnicode=true&characterEncoding=UTF-8";  // 替换为你的数据库名
    private static final String USER = "root";  // 替换为你的数据库用户名
    private static final String PASSWORD = "tlzhoulin666666";  // 替换为你的数据库密码

    // 加载 MySQL 驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


