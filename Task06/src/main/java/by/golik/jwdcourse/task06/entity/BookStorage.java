package by.golik.jwdcourse.task06.entity;

import java.util.HashSet;

public class BookStorage {

    private static BookStorage bookStorage;

    private HashSet<Book> storage = new HashSet<>();

    private static BookStorage getInstance() {
        return bookStorage == null ? (bookStorage = new BookStorage()) : bookStorage;
    }
    public void addBook(Book book) {
        storage.add(book);
    }
    public void removeBook(Book book) {
        storage.remove(book);
    }
}
