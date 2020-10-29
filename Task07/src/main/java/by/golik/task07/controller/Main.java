package by.golik.task07.controller;
import by.golik.task07.dao.BookDao;
import by.golik.task07.dao.Tag;
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

        BookRepository bookRepository = new BookRepository();
        BookDao bookDao = new BookDao();
        bookRepository.finByTag(Tag.TITLE);
        bookRepository.finByTag(Tag.AUTHOR);
        bookRepository.finByTag(Tag.PAGES);
        bookRepository.finByTag(Tag.YEAR);
        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 20));
        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 20));

        System.out.println(bookRepository.getRepository());
        bookDao.write(bookRepository.getRepository());
        bookRepository.sortByTag(Tag.AUTHOR);

    }
}
