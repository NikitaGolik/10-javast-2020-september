package by.golik.jwdcourse.task06;
import by.golik.jwdcourse.task06.dao.BookDao;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.entity.LibraryManager;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import by.golik.jwdcourse.task06.query.search_query.SearchTitleQuery;
import by.golik.jwdcourse.task06.repository.BookRepository;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws IOException, BookAlreadyHaveException, BookNotExistException {

        Book book1 = new Book("Java", "Nikolai", 150,1993);
        Book book2 = new Book("Python", "Masha", 200,2000);
        Book book3 = new Book("JavaScript", "Aleksandr", 130,2015);
        Book book4 = new Book("HTML", "Petr", 230,2020);
        Book book5 = new Book("CSS", "Vladimir", 350,1985);

        BookDao bookDao = new BookDao();
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        bookDao.createBook(books);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.finByTag(Tag.TITLE);
        bookRepository.finByTag(Tag.AUTHOR);
        bookRepository.finByTag(Tag.PAGES);
        bookRepository.finByTag(Tag.YEAR);



        bookRepository.addBook(new Book("Factory", "Mike", 150,300));
        bookRepository.removeBook(new Book("Python", "Masha", 200, 2000));






    }
}
