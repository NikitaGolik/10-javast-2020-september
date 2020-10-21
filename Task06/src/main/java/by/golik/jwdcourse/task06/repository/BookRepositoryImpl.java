package by.golik.jwdcourse.task06.repository;
import by.golik.jwdcourse.task06.dao.BookDaoImpl;
import by.golik.jwdcourse.task06.entity.Book;
import java.io.IOException;
import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    private BookDaoImpl bookDaoImpl;
    Book book;
    @Override
    public Book get(Long id) {
        return null;
    }

    @Override
    public void addBook(Book book) throws IOException {
        bookDaoImpl.createBook(book);
    }

    @Override
    public void removeBook(Book book) {
        removeBook(book);
    }

    @Override
    public Book searchByAuthor(String authorName) {
       return null;
    }

    @Override
    public Book searchById(Long id) {
        return null;
    }

    @Override
    public Book searchByName(String name) {
        return null;
    }

    @Override
    public Book searchByYear(Long year) {
        return null;
    }
    HashMap<String, Book> hashMap;

    public HashMap<String, Book> fill(String title, Book book) {
        HashMap<String, Book> bookHashMap = new HashMap<>();


        for(Map.Entry<String, Book> entry : bookHashMap.entrySet()) {
            bookHashMap.put(book.getTitle(), book);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return bookHashMap;
    }

}
