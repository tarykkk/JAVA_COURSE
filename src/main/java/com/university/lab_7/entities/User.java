package com.university.lab_7.entities;


import java.util.HashMap;
import java.util.Map;

import com.university.lab_7.exceptions.OutOfStockException;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;
    private double balance;

    public User (Integer id, String username, double balance){
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
        this.balance = balance;
    }

    public Integer getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public Map<Product, Integer> getCart(){
        return cart;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addToCart(Product product, int quantity) throws OutOfStockException {
        if(quantity <= 0){
            System.out.println("Quantity can`t be a negative number");
            return;
        }
        int productStock = product.getStock();
        if(productStock >= quantity)
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        else
            throw new OutOfStockException("Not enough stock available");
    }

    public void removeFromCart(Product product){
        if(cart.containsKey(product)) {
            cart.remove(product);
        } else {
            System.out.println("Product was not found in the cart");
        }
    }
    public void modifyCart(Product product, int newQuantity) throws OutOfStockException {
        removeFromCart(product);
        addToCart(product, newQuantity);
    }
    public Map<Product, Integer> getCartCopy() {
        return new HashMap<>(cart);
    }
    @Override
    public String toString(){
        return "id: " + id + ", username: " + username;
    }
}
