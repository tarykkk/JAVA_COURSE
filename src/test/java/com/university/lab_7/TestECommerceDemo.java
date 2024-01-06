package com.university.lab_7;


import com.university.lab_5.NegativeAmountException;
import com.university.lab_7.entities.*;
import com.university.lab_7.exceptions.OutOfStockException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestECommerceDemo {
    private User user1;
    private Product product1;
    private Product product2;
    private Product product3;
    ECommercePlatform platform;
    @BeforeEach
    public void setUp() throws NegativeAmountException {
        product1 = new Product(1, "Laptop", 800.00, 20);
        product2 = new Product(2, "Keyboard", 100.00, 25);
        product3 = new Product(3, "Headphones", 150.00, 15);
        platform = new ECommercePlatform();
        user1 = platform.addUser(1, "Charlie Evans", 1000);
        platform.addUser(2, "Sara Craig", 1000);
        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);
    }
    @Test
    public void testAddToCartSufficientStock() {
        assertDoesNotThrow( ()->user1.addToCart(product1, 5));
        Assertions.assertEquals(5, user1.getCart().get(product1).intValue());
    }
    @Test
    public void testAddToCartInsufficientStock() {
        assertThrows(OutOfStockException.class, ()->user1.addToCart(product1, 50));   
    }
    @Test
    public void testRemoveFromCartExistingProduct() throws OutOfStockException {
          assertDoesNotThrow( ()->user1.addToCart(product1, 4));
          assertDoesNotThrow( ()->user1.removeFromCart(product1));
        Assertions.assertNull(user1.getCart().get(product1));
    }
    @Test
    public void testRemoveFromCartNonExistingProduct() {
        user1.removeFromCart(product1);
        Assertions.assertNull(user1.getCart().get(product1));
    }
    @Test
    public void testCreateOrder() {
        assertDoesNotThrow( ()->user1.addToCart(product1, 7));
        assertDoesNotThrow( ()->user1.addToCart(product2, 3));
        int initialStock1 = product1.getStock();
        int initialStock2 = product2.getStock();

        platform.createOrder(user1);

        Assertions.assertEquals(0, user1.getCart().size());
        Assertions.assertEquals(1, platform.getOrders().size());
        Assertions.assertEquals(initialStock1 - 7, product1.getStock());
        Assertions.assertEquals(initialStock2 - 3, product2.getStock());
    }

    @Test
    public void testUpdateProductStock(){
        platform.updateProductStock(1, 40);
        Assertions.assertEquals(40, product1.getStock());
    }

    @Test
    public void testUpdateProductStockNegativeQuantity(){
        try {
            platform.updateProductStock(1, -12);
        } catch (IllegalArgumentException e){
            Assertions.assertEquals("Quantity can not be a negative number!", e.getMessage());
            Assertions.assertEquals(20, product1.getStock());
        }
    }
    @Test
    public void testUpdateProductStockNonExistingProduct() {
        int productId = 10;
        try {
            platform.updateProductStock(productId, 5);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Product with ID " + productId + " not found!", e.getMessage());
        }
    }
}
