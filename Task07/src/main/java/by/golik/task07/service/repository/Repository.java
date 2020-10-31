package by.golik.task07.service.repository;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.Album;
import by.golik.task07.entity.Book;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;
import by.golik.task07.service.exceptions.BookNotExistException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * interface for actions with bookRepository
 */

public interface Repository {

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
    ArrayList<Book> finByTag(Tag tag) throws IOException;

    ArrayList<Book> sortByTag(Tag tag);











}
