package by.golik.jwdcourse.task06.repository;
import by.golik.jwdcourse.task06.dao.BookDao;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import by.golik.jwdcourse.task06.query.search_query.SearchAuthorQuery;
import by.golik.jwdcourse.task06.query.search_query.SearchPagesQuery;
import by.golik.jwdcourse.task06.query.search_query.SearchTitleQuery;
import by.golik.jwdcourse.task06.query.search_query.SearchYearQuery;
import java.io.IOException;
import java.util.*;

/**
 * Class for actions with repository
 */
public class BookRepositoryImpl implements BookRepository {


    private static Set<Book> repository;

    /**
     * Fill repository with books from file
     * @throws IOException
     */
    public BookRepositoryImpl() throws IOException {
        repository = fill();
    }

    /**
     * add books to repository from file
     * @param book to add
     * @throws BookAlreadyHaveException - if this book repository already has
     */
    @Override
    public void addBook(Book book) throws BookAlreadyHaveException {
        if(repository.contains(book)) {
            throw new BookAlreadyHaveException("Repository already had this book" + book.getTitle());
        } else {
            repository.add(book);
        }
    }

    /**
     * remove books from repository
     * @param book to remove
     * @throws BookNotExistException - if this book doesn't exist in repository
     */
    @Override
    public void removeBook(Book book) throws BookNotExistException {
        if(repository.contains(book)) {
            throw new BookNotExistException("Repository doesn't have this book" + book.getTitle());
        }
        repository.remove(book);
    }

    /**
     * find book by entering tag
     * @param tag - enum tag
     * @return list of book that are found by tag
     */
    @Override
    public ArrayList<Book> finByTag(Tag tag) {
        switch (tag) {
            case TITLE:
            SearchTitleQuery searchTitleQuery = new SearchTitleQuery("Sas");
            return searchTitleQuery.query("sas", repository);

            case AUTHOR:
            SearchAuthorQuery searchAuthorQuery = new SearchAuthorQuery("ss");
            return searchAuthorQuery.query("sas", repository);

            case YEAR:
            SearchYearQuery searchYearQuery = new SearchYearQuery((long) 15);
            return searchYearQuery.query((long) 15, repository);

            case PAGES:
            SearchPagesQuery searchPagesQuery = new SearchPagesQuery((long) 1900);
            return searchPagesQuery.query((long) 1900, repository);

        }
        return null;
    }

    /**
     * fill set of book from file
     * @return set of books
     * @throws IOException
     */
    public Set<Book> fill() throws IOException {
        BookDao bookDao = new BookDao();
        return bookDao.readBook();
    }

}
