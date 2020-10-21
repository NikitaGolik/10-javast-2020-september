package by.golik.jwdcourse.task06.repository;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * interface for actions with bookRepository
 */

public interface BookRepository {

    /**
     * Add book to repository
     * @param book to add
     * @throws BookAlreadyHaveException - if this book repository already has
     */
    void addBook(Book book) throws IOException, BookAlreadyHaveException;

    /**
     * Remove book from repository
     * @param book to remove
     * @throws BookNotExistException - if entering book doesn't exist
     */
    void removeBook(Book book) throws BookNotExistException;

    /**
     * find book by entering tag
     * @param tag - enum tag
     * @return list of books, that were found
     */
    ArrayList<Book> finByTag(Tag tag);

    ArrayList<Book> sortByTag(Tag tag);











}
