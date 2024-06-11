package ru.yuzhakov.shop.webclient.models;

/**
 * Объект с заказом товара.
 */
public class Order {
    private int amount;

    public Order(int amount) {
        this.amount = amount;
    }

    public Order() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
