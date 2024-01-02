package com.university.lab_6;

public class Cinema {
    private int[][][] cinemaHalls;

    public Cinema(int numberOfHalls, int numberOfRows, int numberOfSeats) {
        this.cinemaHalls = new int[numberOfHalls][numberOfRows][numberOfSeats];
    }

    public int[][][] getCinemaHalls() {
        return cinemaHalls;
    }

    public void bookSeats(int hallNumber, int row, int[] seats) throws IllegalArgumentException {
        validateHallAndRow(hallNumber, row);
        for (int seat : seats) {
            if (seat < 0 || seat >= cinemaHalls[hallNumber][row].length) {
                throw new IllegalArgumentException("Invalid seat number: " + seat);
            }
            if (cinemaHalls[hallNumber][row][seat] == 1) {
                throw new IllegalStateException("Seat number " + seat + " is already booked.");
            }
            cinemaHalls[hallNumber][row][seat] = 1;
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) throws IllegalArgumentException {
        validateHallAndRow(hallNumber, row);
        for (int seat : seats) {
            if (seat < 0 || seat >= cinemaHalls[hallNumber][row].length) {
                throw new IllegalArgumentException("Invalid seat number: " + seat);
            }
            cinemaHalls[hallNumber][row][seat] = 0;
        }
    }

    public boolean checkAvailability(int screen, int numSeats) {
        for (int[] row : cinemaHalls[screen]) {
            int consecutiveSeats = 0;
            for (int seat : row) {
                if (seat == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) throws IllegalArgumentException {
        validateHallAndRow(hallNumber, 0);
        for (int[] row : cinemaHalls[hallNumber]) {
            for (int seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    private void validateHallAndRow(int hallNumber, int row) throws IllegalArgumentException {
        if (hallNumber < 0 || hallNumber >= cinemaHalls.length) {
            throw new IllegalArgumentException("Invalid hall number: " + hallNumber);
        }
        if (row < 0 || row >= cinemaHalls[hallNumber].length) {
            throw new IllegalArgumentException("Invalid row number: " + row);
        }
    }
}