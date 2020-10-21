package by.golik.jwdcourse.task06.repository;

import by.golik.jwdcourse.task06.entity.Book;
import java.io.IOException;



public interface BookRepository {

    Book get(Long id);

    void addBook(Book book) throws IOException;

    void removeBook(Book book);

    Book searchByAuthor(String authorName);

    Book searchById(Long id);

    Book searchByName(String name);

    Book searchByYear(Long year);








}
