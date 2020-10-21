package by.golik.jwdcourse.task06;
import by.golik.jwdcourse.task06.dao.BookDaoImpl;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.repository.BookRepository;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book book1 = new Book("book1", "author1", 15, 504);
        Book book2 = new Book("book2", "author2", 125, 500);
        Book book3 = new Book("book3", "author3", 145, 508);
        Book book4 = new Book("book4", "author4", 1565, 540);
        Book book5 = new Book("book5", "author5", 115, 510);

        BookDaoImpl bookDao = new BookDaoImpl();
//        bookDao.createBook(book1);
//        bookDao.createBook(book2);
//        bookDao.createBook(book3);
//        bookDao.createBook(book4);
//        bookDao.createBook(book5);
//        bookDao.readBook();
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.addBook(book1);







    }
}
