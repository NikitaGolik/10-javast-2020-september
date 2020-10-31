package by.golik.task07.entity;
import by.golik.task07.dao.BookDao;
import by.golik.task07.service.observers.Observable;
import by.golik.task07.service.observers.Observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Nikita Golik
 */
public class BookStore  {


    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public BookStore() throws IOException {
        BookDao bookDao = new BookDao();
        this.bookList = new ArrayList<>(bookDao.createBook(bookDao.read()));
    }



}
