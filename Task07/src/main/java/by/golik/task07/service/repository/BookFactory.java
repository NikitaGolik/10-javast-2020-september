package by.golik.task07.service.repository;
import by.golik.task07.entity.*;
import by.golik.task07.entity.BookType;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Nikita Golik
 */
public class BookFactory {
    BookRepository bookRepository = new BookRepository();

    public BookFactory() throws IOException {
    }

    public Book getBook(BookType type) throws IOException, BookAlreadyHaveException {
        Book toReturn = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String title = reader.readLine();
        System.out.println("Введите фамилию автора");
        String author = reader.readLine();
        System.out.println("Введите количество страниц");
        int pages = Integer.parseInt(reader.readLine());
        System.out.println("Введите год издания");
        int years = Integer.parseInt(reader.readLine());
        switch (type) {
            case BOOK:
                toReturn = new Book(title, author, pages, years);
                bookRepository.addBook(toReturn);
                break;
            case ALBUM:
                toReturn = new Album(title, author, pages, years);
                bookRepository.addBook(toReturn);
                break;
            case MAGAZINE:
                toReturn = new Magazine(title, author, pages, years);
                bookRepository.addBook(toReturn);
                break;
            case NEWSPAPER:
                toReturn = new Newspaper(title, author, pages, years);
                bookRepository.addBook(toReturn);
                break;
            default:
                throw new IllegalArgumentException("Wrong edition type" + type);
        }
        return toReturn;
    }
}
