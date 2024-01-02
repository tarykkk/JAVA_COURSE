package com.university.lab_3;

import java.util.List;

public class Order {
    private static int counter = 1;
    private int orderId;
    private List<Product> products;
    private Status status;

    public Order(List<Product> products) {
        this.orderId = counter++;
        this.products = products;
        this.status = Status.CREATED;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public int getOrderId() {
        return orderId;
    }
    public List<Product> getProducts() {
        return products;
    }
    public Status getStatus() {
        return status;
    }
}
