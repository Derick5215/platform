package com.platform;

import java.math.BigDecimal;

public class Order {
    private int id;
    private String productName;
    private int quantity;
    private BigDecimal totalPrice;
    private String orderRate;  // 订单状态：'Pending', 'Paid'

    // 构造方法
    public Order(int id, String productName, int quantity, BigDecimal totalPrice, String orderRate) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderRate = orderRate;
    }


    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(String orderRate) {
        this.orderRate = orderRate;
    }
}
