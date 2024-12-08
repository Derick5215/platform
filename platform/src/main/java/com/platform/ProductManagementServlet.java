package com.platform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductManagementServlet")
public class ProductManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从数据库中获取商品列表
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts();

        // 将商品列表传递到JSP页面
        request.setAttribute("products", products);

        // 转发到商品管理JSP页面
        request.getRequestDispatcher("/productManagement.jsp").forward(request, response);
    }
}

