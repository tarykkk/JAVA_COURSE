package com.university.lab_2;

import org.junit.jupiter.api.*;
import com.university.lab_2.DVD;
import com.university.lab_2.Book;
import com.university.lab_2.Library;
import com.university.lab_2.Patron;
public class TestLibrary {
    private Library library;
    private Book book;
    private Patron patron;
    private DVD dvd;
    @BeforeEach
    public void setUp(){
        library = new Library();
        book = new Book("I Am Legend", "IDB00001", "Richard Matheson");
        dvd = new DVD("Oppenheimer", "IDD00001", 180);
        patron = new Patron("Sara Lloyd", "PN00001");
    }
    @Test
    public void testAddItem(){
        library.addItem(book);
        library.addItem(dvd);
        Assertions.assertEquals(2, library.listAvailable().size());
    }
    @Test
    public void testRemoveItem(){
        library.addItem(book);
        library.addItem(dvd);
        library.removeItem(book);
        library.removeItem(dvd);
        Assertions.assertEquals(0, library.listAvailable().size());
    }
    @Test
    public void testRegisterPatron(){
        library.registerPatron(patron);
        Assertions.assertTrue(library.get_patrons().contains(patron));
    }
    @Test
    public void testLendAndReturnItem(){
        library.addItem(book);
        library.addItem(dvd);
        library.registerPatron(patron);

        library.lendItem(patron, book);
        Assertions.assertTrue(patron.get_borrowedItems().contains(book));
        Assertions.assertTrue(book.getIsBorrowed());

        library.returnItem(patron, book);
        Assertions.assertFalse(patron.get_borrowedItems().contains(book));
        Assertions.assertFalse(book.getIsBorrowed());
    }
    @Test
    public void testListAvailableItems(){
        library.addItem(book);
        library.addItem(dvd);
        Assertions.assertEquals(2, library.listAvailable().size());
    }
    @Test
    public void testListBorrowedItems(){
        library.addItem(book);
        library.addItem(dvd);
        library.registerPatron(patron);

        library.lendItem(patron, book);
        library.lendItem(patron, dvd);
        Assertions.assertEquals(2, patron.get_borrowedItems().size());
    }
}
