package by.golik.task07.controller;
import by.golik.task07.dao.BookDao;
import by.golik.task07.entity.Book;
import by.golik.task07.exceptions.BookAlreadyHaveException;
import by.golik.task07.exceptions.BookNotExistException;
import by.golik.task07.query.search_query.SearchAuthorQuery;
import by.golik.task07.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, BookAlreadyHaveException, BookNotExistException {

        logger.trace("Trace");
        logger.info("Log4j2 started.");
        logger.warn("Something to warn");
        logger.error("Something failed.");
        logger.fatal("Fatal");
        logger.debug("Debug");
        BookDao bookDao = new BookDao();
        BookRepository bookRepository = new BookRepository();

        SearchAuthorQuery searchAuthorQuery = new SearchAuthorQuery("Голик");
        searchAuthorQuery.query(bookRepository.getRepository());

    }
}
