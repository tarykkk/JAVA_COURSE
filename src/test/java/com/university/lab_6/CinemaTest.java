package com.university.lab_6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema(3, 5, 5);
    }

    @Test
    void testDefaultCinemaHallCreation() {
        int[][][] halls = cinema.getCinemaHalls();
        assertEquals(3, halls.length);
        assertEquals(5, halls[0].length); 
        assertEquals(5, halls[0][0].length);  
    }

    @Test
    void testBookSeats() throws IllegalArgumentException {
        cinema.bookSeats(1, 1, new int[]{1, 2});
        int[][][] halls = cinema.getCinemaHalls();
        assertEquals(1, halls[1][1][1]); 
        assertEquals(1, halls[1][1][2]);
    }

    @Test
    void testInvalidBooking() {
        assertThrows(IllegalArgumentException.class, () -> cinema.bookSeats(5, 1, new int[]{1, 2})); 
        assertThrows(IllegalArgumentException.class, () -> cinema.bookSeats(1, 10, new int[]{1, 2})); 
        assertThrows(IllegalArgumentException.class, () -> cinema.bookSeats(1, 1, new int[]{10, 11})); 
    }

    @Test
    void testBookingAlreadyBookedSeats() throws IllegalArgumentException {
        cinema.bookSeats(1, 1, new int[]{1, 2});
        assertThrows(IllegalStateException.class, () -> cinema.bookSeats(1, 1, new int[]{1, 2}));
    }

    @Test
    void testCancelBooking() throws IllegalArgumentException {
        cinema.bookSeats(1, 1, new int[]{1, 2});
        cinema.cancelBooking(1, 1, new int[]{1, 2});
        int[][][] halls = cinema.getCinemaHalls();
        assertEquals(0, halls[1][1][1]);
        assertEquals(0, halls[1][1][2]);
    }

    @Test
    void testCheckAvailability() {
        assertTrue(cinema.checkAvailability(1, 3));
        assertFalse(cinema.checkAvailability(1, 10));
    }

    @Test
    void testPrintSeatingArrangement() {
        assertDoesNotThrow(() -> cinema.printSeatingArrangement(1));
        assertThrows(IllegalArgumentException.class, () -> cinema.printSeatingArrangement(5));
    }
}