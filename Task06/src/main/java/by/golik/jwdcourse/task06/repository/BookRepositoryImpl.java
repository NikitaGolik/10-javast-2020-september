package by.golik.jwdcourse.task06.repository;
import by.golik.jwdcourse.task06.dao.BookDaoImpl;
import by.golik.jwdcourse.task06.entity.Book;
import java.util.HashSet;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private BookDaoImpl bookDaoImpl;

    @Override
    public void add(Book book) {
        bookDaoImpl.addBook(book);

    }

    @Override
    public void remove(Book book) {
        bookDaoImpl.removeBook(book);

    }

}
