package com.university.lab_1;

import com.university.lab_1.Book;
import com.university.lab_1.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestLibrary {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Book 1", "Author 1", "ISBN001", 2020);
        library.addBook(book);
        Assertions.assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        Library library = new Library();
        Book book = new Book("Book 1", "Author 1", "ISBN001", 2020);
        library.addBook(book);

        Book foundBook = library.findBookByTitle("Book 1");
        Assertions.assertNotNull(foundBook);
        Assertions.assertEquals("Book 1", foundBook.getTitle());
    }

    @Test
    public void testRemoveBookByIsbn() {
        Library library = new Library();
        Book book = new Book("Book 1", "Author 1", "ISBN001", 2020);
        library.addBook(book);

        library.removeBookByIsbn("ISBN001");
        Assertions.assertEquals(0, library.getBooks().size());
    }
}
