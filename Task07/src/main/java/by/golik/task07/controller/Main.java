package by.golik.task07.controller;
import by.golik.task07.dao.BookDao;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.*;
import by.golik.task07.exceptions.BookAlreadyHaveException;
import by.golik.task07.exceptions.BookNotExistException;
import by.golik.task07.service.observers.AlbumObserver;
import by.golik.task07.service.observers.BookObserver;
import by.golik.task07.service.observers.MagazineObserver;
import by.golik.task07.service.repository.BookRepository;
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

        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 2003));
        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 2002));
        bookRepository.addBook(new Album("Первый альбом", "Сидоров", 40, 1995));
        bookRepository.addBook(new Magazine("Первый журнал", "Григорьев", 404, 2005));
        bookRepository.addBook(new Newspaper("Первая газета", "Солодаев", 25, 2010));

        BookStore observable = new BookStore();
        AlbumObserver albumObserver = new AlbumObserver();
        BookObserver bookObserver = new BookObserver();
        MagazineObserver magazineObserver = new MagazineObserver();

        observable.addObserver(albumObserver);
        observable.addObserver(bookObserver);
        observable.addObserver(magazineObserver);

        observable.setCountOfBooks(200);


        System.out.println(bookRepository.getRepository());
        bookDao.write(bookRepository.getRepository());
        bookRepository.sortByTag(Tag.AUTHOR);

    }
}
