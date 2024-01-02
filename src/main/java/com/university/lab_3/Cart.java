package com.university.lab_3;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeFromCart(Product product){
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
