package by.golik.task07.service.exceptions;

/**
 * Class for exception, which can appear with adding a book, that already library has
 */
public class BookAlreadyHaveException extends Exception {

    public BookAlreadyHaveException(String message) {

        super(message);
    }
}
