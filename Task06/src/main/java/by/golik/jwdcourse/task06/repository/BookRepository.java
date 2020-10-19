package by.golik.jwdcourse.task06.repository;

import by.golik.jwdcourse.task06.entity.Book;

import java.util.List;

public interface BookRepository {

    Book get(Long id);

    void add(Book book);

    void remove(Book book);

}
