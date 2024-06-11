package ru.yuzhakov.shop.webclient.models;

import java.math.BigDecimal;

/**
 * Объект с товаром.
 */
public class Product {
    private Long id;
    private String name;
    private int amount;
    private BigDecimal price;

    public Product(Long id, String name, int amount, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
