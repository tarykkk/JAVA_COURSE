package com.university.lab_3;

public class CommerceSystem {
    public static void main(String[] args) {
        Product laptop = new Product(1, "Computer", 999.99F);
        Product smartphone = new Product(2, "GPU", 499.99F);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(smartphone);

        System.out.println("Cart:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice());

            Order order = new Order(cart.getProducts());
            System.out.println("\norder placed. Order ID: " + order.getOrderId());

            order.setStatus(Status.PROCESSING);
            System.out.println("Status: " + order.getStatus());
        }
    }
}
