package com.university.lab_3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestCommerceSystem {

    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        cart.addProduct(new Product(1, "PC", 500F));
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product prod = new Product(1, "GPU", 500F);
        cart.addProduct(prod);
        cart.removeFromCart(prod);
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testPlaceOrder() {
        Cart cart = mock(Cart.class);
        Product prod = new Product(1, "GPU", 500F);
        when(cart.getProducts()).thenReturn(List.of(prod));
        Order order = new Order(cart.getProducts());
        assertEquals(1, order.getProducts().size());
        assertEquals(Status.CREATED, order.getStatus());
    }

    @Test
    public void testUpdateOrderStatus() {
        Order order = new Order(List.of());
        order.setStatus(Status.PROCESSING);
        assertEquals(Status.PROCESSING, order.getStatus());
    }

    @Test
    public void testGetOrderStatus() {
        Order order = mock(Order.class);
        when(order.getStatus()).thenReturn(Status.PROCESSING);
        Status status = order.getStatus();
        assertEquals(Status.PROCESSING, status);
    }
}
