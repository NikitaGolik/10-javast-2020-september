package by.golik.jwdcourse.task06.repository;

import by.golik.jwdcourse.task06.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository<Entity, Registrator> {

    void add(Book book);

    void remove(Book book);

    ArrayList<Book> specification = null;

}
