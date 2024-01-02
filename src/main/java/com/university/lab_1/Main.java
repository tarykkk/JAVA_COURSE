package com.university.lab_1;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Book 1", "Author 1", "ISBN001", 2020);
        Book book2 = new Book("Book 2", "Author 2", "ISBN002", 2018);
        library.addBook(book1);
        library.addBook(book2);

        System.out.println("All books in the library:");
        library.showAllBooks();

        String searchTitle = "Book 1";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found book by title '" + searchTitle + "': " + foundBook);
        } else {
            System.out.println("Book with title '" + searchTitle + "' not found.");
        }

        String isbnToDelete = "ISBN001";
        library.removeBookByIsbn(isbnToDelete);
        System.out.println("Book with ISBN '" + isbnToDelete + "' has been removed.");

        System.out.println("All books in the library after deletion:");
        library.showAllBooks();
    }
}