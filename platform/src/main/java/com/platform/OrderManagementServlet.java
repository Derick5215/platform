package com.platform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderManagementServlet")
public class OrderManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从数据库中获取所有订单
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getAllOrders();

        // 将订单列表传递到JSP页面
        request.setAttribute("orders", orders);

        // 转发到订单管理JSP页面
        request.getRequestDispatcher("/orderManagement.jsp").forward(request, response);
    }
}
