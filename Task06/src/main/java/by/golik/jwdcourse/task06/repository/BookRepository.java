package by.golik.jwdcourse.task06.repository;

import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;

import java.io.IOException;
import java.util.ArrayList;


public interface BookRepository {


    void addBook(Book book) throws IOException, BookAlreadyHaveException;

    void removeBook(Book book) throws BookNotExistException;

    ArrayList<Book> finByTag(Tag tag);











}
