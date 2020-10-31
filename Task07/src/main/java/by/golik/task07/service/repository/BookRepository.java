package by.golik.task07.service.repository;
import by.golik.task07.controller.Main;
import by.golik.task07.dao.BookDao;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.Book;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;
import by.golik.task07.service.exceptions.BookNotExistException;
import by.golik.task07.service.observers.Observable;
import by.golik.task07.service.observers.Observer;
import by.golik.task07.service.query.search_query.SearchAuthorQuery;
import by.golik.task07.service.query.search_query.SearchPagesQuery;
import by.golik.task07.service.query.search_query.SearchTitleQuery;
import by.golik.task07.service.query.search_query.SearchYearQuery;
import by.golik.task07.service.query.sort_query.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Class for actions with repository
 */
public class BookRepository implements Repository, Observable {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private List<Observer> observers = new ArrayList<>();
    private static List<Book> repository;

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(repository);
        }
    }


    /**
     * Fill repository with books from file
     * @throws IOException
     */
    public BookRepository() throws IOException {
        BookDao bookDao = new BookDao();
        repository = bookDao.createBook(bookDao.read());
    }

    public List<Book> getRepository() {
        return repository;
    }

    public static void setRepository(List<Book> repository) {
       BookRepository.repository = repository;
    }

    /**
     * add books to repository from file
     * @param book to add
     * @throws BookAlreadyHaveException - if this book repository already has
     */
    @Override
    public void addBook(Book book) throws BookAlreadyHaveException {
        if(repository.contains(book)) {
            throw new BookAlreadyHaveException("Repository already had this book " + book.getTitle());
        } else {
            repository.add(book);
            notifyObservers();
        }
    }

    @Override
    public void update(Book book) {

    }

    /**
     * remove books from repository
     * @param book to remove
     * @throws BookNotExistException - if this book doesn't exist in repository
     */
    @Override
    public void removeBook(Book book) throws BookNotExistException {
        if(repository.contains(book)) {
            repository.remove(book);
            notifyObservers();
        } else {
            throw new BookNotExistException("Repository doesn't have this book" + book.getTitle());
        }
    }

    /**
     * find book by entering tag
     * @param tag - enum tag
     * @return list of book that are found by tag
     */
    @Override
    public ArrayList<Book> finByTag(Tag tag) throws IOException {

        logger.info("Log4j2 started.");
        logger.warn("Ошибка при получении объектов из BookDao");
        logger.error("Ошибка при получении объектов из BookDao");
        logger.fatal("Fatal with Find ByTag");

        System.out.println("Введите ключ для поиска");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyToSearch = reader.readLine();

        switch (tag) {
            case TITLE:
            SearchTitleQuery searchTitleQuery = new SearchTitleQuery(keyToSearch);
            return searchTitleQuery.query(repository);

            case AUTHOR:
            SearchAuthorQuery searchAuthorQuery = new SearchAuthorQuery(keyToSearch);
            return searchAuthorQuery.query(repository);

            case YEAR:
            SearchYearQuery searchYearQuery = new SearchYearQuery( Integer.parseInt(keyToSearch));
            return searchYearQuery.query(repository);

            case PAGES:
            SearchPagesQuery searchPagesQuery = new SearchPagesQuery( Integer.parseInt(keyToSearch));
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
            case TITLEAUTHOR:
                SortByTitleThenAuthor sortByTitleThenAuthor = new SortByTitleThenAuthor();
                return sortByTitleThenAuthor.query(repository);
            case AUTHORTITLE:
                SortByAuthorThenTitle sortByAuthorThenTitle = new SortByAuthorThenTitle();
                return sortByAuthorThenTitle.query(repository);
            case PAGESYEAR:
                SortByPagesThenYear sortByPagesThenYear = new SortByPagesThenYear();
                return sortByPagesThenYear.query(repository);
            case YEARPAGES:
                SortByYearThenPages sortByYearThenPages = new SortByYearThenPages();
                return sortByYearThenPages.query(repository);
        }
        return null;
    }

}
