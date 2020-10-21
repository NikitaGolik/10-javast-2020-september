package by.golik.jwdcourse.task06.repository;
import by.golik.jwdcourse.task06.dao.BookDao;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import by.golik.jwdcourse.task06.query.search_query.SearchTitleQuery;
import by.golik.jwdcourse.task06.query.sort_query.SortByAuthor;

import java.io.IOException;
import java.util.*;

public class BookRepositoryImpl implements BookRepository {


    private static Set<Book> repository;

    public BookRepositoryImpl() throws IOException {
        repository = fill();
    }

    @Override
    public void addBook(Book book) throws BookAlreadyHaveException {
        if(repository.contains(book)) {
            throw new BookAlreadyHaveException("Repository already had this book" + book.getTitle());
        } else {
            repository.add(book);
        }
    }

    @Override
    public void removeBook(Book book) throws BookNotExistException {
        if(repository.contains(book)) {
            throw new BookNotExistException("Repository doesn't have this book" + book.getTitle());
        }
        repository.remove(book);
    }

    @Override
    public ArrayList<Book> finByTag(Tag tag) {
        SearchTitleQuery searchTitleQuery = new SearchTitleQuery("Sas");
        searchTitleQuery.query("sas", repository);

        return searchTitleQuery.query("sas", repository);
    }

    public Set<Book> fill() throws IOException {
        BookDao bookDao = new BookDao();
        return bookDao.readBook();
    }

}
