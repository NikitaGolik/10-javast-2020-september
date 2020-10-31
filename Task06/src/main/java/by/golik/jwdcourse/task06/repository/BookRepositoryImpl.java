package by.golik.jwdcourse.task06.repository;
import by.golik.jwdcourse.task06.controller.Main;
import by.golik.jwdcourse.task06.dao.BookDao;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import by.golik.jwdcourse.task06.query.search_query.SearchAuthorQuery;
import by.golik.jwdcourse.task06.query.search_query.SearchPagesQuery;
import by.golik.jwdcourse.task06.query.search_query.SearchTitleQuery;
import by.golik.jwdcourse.task06.query.search_query.SearchYearQuery;
import by.golik.jwdcourse.task06.query.sort_query.SortByAuthor;
import by.golik.jwdcourse.task06.query.sort_query.SortByPages;
import by.golik.jwdcourse.task06.query.sort_query.SortByTitle;
import by.golik.jwdcourse.task06.query.sort_query.SortByYear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.*;

/**
 * Class for actions with repository
 */
public class BookRepositoryImpl implements BookRepository {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static ArrayList<Book> repository;



    /**
     * Fill repository with books from file
     * @throws IOException
     */
    public BookRepositoryImpl() throws IOException {
        BookDao bookDao = new BookDao();
        repository = bookDao.createBook(bookDao.read());
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


        logger.info("Log4j2 started.");
        logger.warn("Ошибка при получении объектов из BookDao");
        logger.error("Ошибка при получении объектов из BookDao");
        logger.fatal("Fatal with Find ByTag");


        switch (tag) {
            case TITLE:
            SearchTitleQuery searchTitleQuery = new SearchTitleQuery("Sas");
            return searchTitleQuery.query(repository);

            case AUTHOR:
            SearchAuthorQuery searchAuthorQuery = new SearchAuthorQuery("ss");
            return searchAuthorQuery.query(repository);

            case YEAR:
            SearchYearQuery searchYearQuery = new SearchYearQuery((long) 15);
            return searchYearQuery.query(repository);

            case PAGES:
            SearchPagesQuery searchPagesQuery = new SearchPagesQuery((long) 1900);
            return searchPagesQuery.query(repository);

        }
        return null;
    }

    @Override
    public ArrayList<Book> sortByTag(Tag tag) {
        logger.info("Log4j2 started.");
        logger.warn("Ошибка при получении объектов из BookDao");
        logger.error("Ошибка при получении объектов из BookDao");
        logger.fatal("Fatal with sort");

        switch (tag) {
            case TITLE:
                SortByTitle sortByTitle = new SortByTitle();
                return sortByTitle.query(repository);

            case AUTHOR:
                SortByAuthor sortByAuthor = new SortByAuthor();
                return sortByAuthor.query(repository);

            case YEAR:
                SortByYear sortByYear = new SortByYear();
                return sortByYear.query(repository);

            case PAGES:
                SortByPages sortByPages = new SortByPages();
                return sortByPages.query(repository);

        }
        return null;
    }
}
