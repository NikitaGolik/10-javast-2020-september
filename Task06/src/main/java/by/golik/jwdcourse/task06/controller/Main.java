package by.golik.jwdcourse.task06.controller;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;
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

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.finByTag(Tag.TITLE);
        bookRepository.finByTag(Tag.AUTHOR);
        bookRepository.finByTag(Tag.YEAR);
        bookRepository.finByTag(Tag.PAGES);

        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 20));
        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 20));
        System.out.println(bookRepository);

    }
}
