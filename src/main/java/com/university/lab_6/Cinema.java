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

        System.out.print("     ");
        for (int i = 1; i <= cinemaHalls[hallNumber][0].length; i++){
            System.out.print( (i <= 9 ? " " : "") + i + " ");
        }
        System.out.println();

        int i = 1;
        for (int[] row : cinemaHalls[hallNumber]) {

            if(i <= 9) {
                System.out.print(" ");
            }

            System.out.print(i + " |");
            System.out.print("\u001B[40m" + "\u001B[32m");
            System.out.print(" ");
            for (int seat : row) {
                if(seat == 0) {
                    System.out.print(" "+ seat + " ");
                }
                else
                {
                    System.out.print("\u001B[31m" + "\u001B[43m");
                    System.out.print(" "+ seat + " ");
                    System.out.print("\u001B[40m" + "\u001B[32m");
                }
            }
            System.out.print("\u001B[0m");
            System.out.println("| " + i);

            i++;
        }

        System.out.print("     ");
        for (int j = 1; j <= cinemaHalls[hallNumber][0].length; j++){
            System.out.print( (j <= 9 ? " " : "") + j + " ");
        }
        System.out.println();
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