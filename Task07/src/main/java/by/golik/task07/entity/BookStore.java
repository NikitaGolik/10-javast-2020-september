package by.golik.task07.entity;

import by.golik.task07.service.repository.BookRepository;

import java.io.IOException;
import java.util.Set;

/**
 * @author Nikita Golik
 */
public class BookStore {
    private static Set<Book> bookStore;
    BookRepository bookRepository = new BookRepository();


    public BookStore() throws IOException {
        bookStore = bookRepository.getRepository();
    }
}
