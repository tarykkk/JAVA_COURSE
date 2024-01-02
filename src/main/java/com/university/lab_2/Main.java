package com.university.lab_2;


public class Main {
    public static void main(String[] args) {
        /*
        todo:
        Modify the library system
        1. Create an abstract class Item
        2. Create a class Book that implements Item
        3. Create a class DVD that implements Item
        4. Create a class Patron that represents a customer
        5. Create an interface IManageable
        6. Create a class Library that implements IManageable
        7. Create a class TestLibrary to test functionality
        * */
        Library library = new Library();

        Book book1 = new Book("The Hunger Games", "IDB00001", "Suzanne Collins");
        Book book2 = new Book("Fahrenheit 451", "IDB00002", "Ray Bradbury");
        DVD dvd = new DVD("The Creator", "IDD00001", 133);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd);

        Patron patron1 = new Patron("Alisa McGuire", "PN00001");
        Patron patron2 = new Patron("Charlie Stone", "PN00002");

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        System.out.println(library.listAvailable());

        library.lendItem(patron1, book2);
        library.lendItem(patron2, dvd);

        System.out.println("Available: ");
        for(Item item : library.listAvailable()){
            System.out.println(item.get_title());
        }

        System.out.println("Borrowed: ");
        for(Patron patron : library.get_patrons()){
            for(Item item : patron.get_borrowedItems()){
                System.out.println(patron.get_name() + ": " + item.get_title());
            }
        }
    }
}