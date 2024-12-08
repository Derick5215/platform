package com.platform;
import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.description = description;
    }

    // 构造函数：不带id，适用于添加新商品
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.description = description;
    }

    public  Product() {

    }
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
