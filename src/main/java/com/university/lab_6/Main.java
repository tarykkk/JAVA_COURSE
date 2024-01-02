package com.university.lab_6;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);
        cinema.bookSeats(1, 4, new int[]{5, 6, 7});
        cinema.printSeatingArrangement(1);
        System.out.println(cinema.checkAvailability(1, 4));
    }
}