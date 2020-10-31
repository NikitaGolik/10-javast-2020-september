package by.golik.task07.controller;
import by.golik.task07.dao.BookDao;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.*;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;
import by.golik.task07.service.exceptions.BookNotExistException;
import by.golik.task07.service.observers.AlbumObserver;
import by.golik.task07.service.observers.NewspaperObserver;
import by.golik.task07.service.observers.MagazineObserver;
import by.golik.task07.service.repository.BookFactory;
import by.golik.task07.service.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, BookAlreadyHaveException, BookNotExistException {
        Controller controller = new Controller(new Scanner(System.in));

//        logger.trace("Trace");
//        logger.info("Log4j2 started.");
//        logger.warn("Something to warn");
//        logger.error("Something failed.");
//        logger.fatal("Fatal");
//        logger.debug("Debug");
//
//        BookRepository bookRepository = new BookRepository();
        BookDao bookDao = new BookDao();
        BookRepository bookRepository = new BookRepository();
        BookFactory bookFactory = new BookFactory();

        bookRepository.addBook(new Book("sa", "sa", 20, 50));
        bookRepository.removeBook(new Book("sa", "sa", 20, 50));
        System.out.println(bookRepository.getRepository());
        bookFactory.getBook(BookType.ALBUM);
        bookDao.write(bookRepository.getRepository());
        System.out.println(bookRepository.getRepository());



//        bookRepository.finByTag(Tag.TITLE);
//        bookRepository.finByTag(Tag.AUTHOR);
//        bookRepository.finByTag(Tag.PAGES);
//        bookRepository.finByTag(Tag.YEAR);
//
//        bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 2003));
//        bookRepository.addBook(new Book("Гаррт Поттер", "Роулинг", 20, 2002));
//        bookRepository.addBook(new Album("Первый альбом", "Сидоров", 40, 1995));
//        bookRepository.addBook(new Magazine("Первый журнал", "Григорьев", 404, 2005));
//        bookRepository.addBook(new Newspaper("Первая газета", "Солодаев", 25, 2010));
//
//        BookStore observable = new BookStore();
//        AlbumObserver albumObserver = new AlbumObserver();
//        NewspaperObserver newspaperObserver = new NewspaperObserver();
//        MagazineObserver magazineObserver = new MagazineObserver();
//
//        observable.addObserver(albumObserver);
//        observable.addObserver(newspaperObserver);
//        observable.addObserver(magazineObserver);
//
//        observable.notifyObservers();
//
//        System.out.println(observable.getBookList());
//
//        System.out.println(bookRepository.getRepository());
//        bookDao.write(bookRepository.getRepository());
//        bookRepository.sortByTag(Tag.AUTHOR);

    }
}
