package by.golik.task07.controller;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.Book;
import by.golik.task07.entity.BookType;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;
import by.golik.task07.service.repository.BookFactory;
import by.golik.task07.service.repository.BookRepository;
import by.golik.task07.view.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
    Scanner scanner;
    BookRepository bookRepository = new BookRepository();
    BookFactory bookFactory = new BookFactory();

    public Controller(Scanner scanner) throws IOException {
        this.scanner = scanner;
    }

    public void start() throws IOException, BookAlreadyHaveException {
        if (scanner != null) {
            String key;
            do {
                Menu menu = new Menu();
                menu.printMenu();
                System.out.println("Введите номер меню");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                    bookRepository.finByTag(Tag.TITLE);
                    break;
                    case "2" :
                        bookRepository.finByTag(Tag.AUTHOR);
                        break;
                    case "3" :
                        bookRepository.finByTag(Tag.PAGES);
                        break;
                    case "4" :
                        bookRepository.finByTag(Tag.YEAR);
                        break;
                    case "5" :
                        bookRepository.sortByTag(Tag.TITLE);
                        break;
                    case "6" :
                        bookRepository.sortByTag(Tag.AUTHOR);
                        break;
                    case "7" :
                        bookRepository.sortByTag(Tag.PAGES);
                        break;
                    case "8" :
                        bookRepository.sortByTag(Tag.YEAR);
                        break;
                    case "9" :
                        bookRepository.sortByTag(Tag.TITLEAUTHOR);
                        break;
                    case "10" :
                        bookRepository.sortByTag(Tag.AUTHORTITLE);
                        break;
                    case "11" :
                        bookRepository.sortByTag(Tag.PAGESYEAR);
                        break;
                    case "12" :
                        bookRepository.sortByTag(Tag.YEARPAGES);
                        break;
                    case "13" :
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        String title = reader.readLine();
                        String author = reader.readLine();
                        int pages = Integer.parseInt(reader.readLine());
                        int year = Integer.parseInt(reader.readLine());
                        bookRepository.addBook(new Book(title, author, pages, year));
                        break;
                    case "14" :
                        bookFactory.getBook(BookType.ALBUM);
                        break;
                    case "15" :
                        bookFactory.getBook(BookType.MAGAZINE);
                        break;
                    case "16" :
                        bookFactory.getBook(BookType.NEWSPAPER);
                    default:
                        throw new IllegalStateException("Unexpected value: " + key);
                }
            } while (!key.equals("20"));

        }

    }

}
