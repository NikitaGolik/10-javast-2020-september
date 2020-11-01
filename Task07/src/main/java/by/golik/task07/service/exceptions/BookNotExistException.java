package by.golik.task07.service.exceptions;

/**
 * Class for exception, which can appear with removing a book, if library hasn't this book
 */
public class BookNotExistException extends Exception {

    public BookNotExistException(String message) {
        super(message);
    }
}
