package by.golik.jwdcourse.task06.dao;

import by.golik.jwdcourse.task06.entity.Book;

import java.util.List;

public interface BookDao {


    void addBook (Book book);

    void removeBook(Book book);

    void findByTag();

    void sortByTag();

}
