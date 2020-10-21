package by.golik.jwdcourse.task06.entity;


import java.util.ArrayList;
import java.util.Arrays;

public class LibraryManager {
    private ArrayList<Book> books;

    public LibraryManager() {
        books = new ArrayList<>();
    }
    public ArrayList<Book> addList() {
        Book book1 = new Book("book1", "author1", 15, 504);
        Book book2 = new Book("book2", "author2", 125, 500);
        Book book3 = new Book("book3", "author3", 145, 508);
        Book book4 = new Book("book4", "author4", 1565, 540);
        Book book5 = new Book("book5", "author5", 115, 510);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        return books;
    }

    @Override
    public String toString() {
        return "LibraryManager{" +
                "books=" + books +
                '}';
    }
}


