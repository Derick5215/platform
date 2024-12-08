package com.platform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        Product product = new Product(name, price, description);
        ProductDao productDao = new ProductDao();
        boolean result = productDao.addProduct(product);

        if (result) {
            response.sendRedirect("productManagement.jsp");
        } else {
            response.sendRedirect("productManagement.jsp?error=添加商品失败");
        }
    }
}


