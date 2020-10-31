package by.golik.task07.controller;
import by.golik.task07.dao.BookDao;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.BookType;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;
import by.golik.task07.service.exceptions.BookNotExistException;
import by.golik.task07.service.observers.AlbumObserver;
import by.golik.task07.service.observers.MagazineObserver;
import by.golik.task07.service.observers.NewspaperObserver;
import by.golik.task07.service.repository.BookFactory;
import by.golik.task07.service.repository.BookRepository;
import by.golik.task07.view.Menu;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    Scanner scanner;
    BookDao bookDao;
    BookRepository bookRepository = new BookRepository();
    BookFactory bookFactory = new BookFactory();


    public void observe() {

        AlbumObserver albumObserver = new AlbumObserver();
        NewspaperObserver newspaperObserver = new NewspaperObserver();
        MagazineObserver magazineObserver = new MagazineObserver();

        bookRepository.addObserver(albumObserver);
        bookRepository.addObserver(newspaperObserver);
        bookRepository.addObserver(magazineObserver);
    }



    public Controller(Scanner scanner) throws IOException {
        this.scanner = scanner;
    }

    public void start() throws IOException, BookAlreadyHaveException, BookNotExistException {
        if (scanner != null) {
            String key;
            do {
                Menu menu = new Menu();
                menu.printMenu();
                System.out.println("Введите номер меню");
                key = this.scanner.nextLine();
                switch (key) {
                    case "0" :
                        System.out.println(bookRepository.getRepository());
                        break;
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
                        bookFactory.getBook(BookType.BOOK);
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "14" :
                        bookFactory.getBook(BookType.ALBUM);
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "15" :
                        bookFactory.getBook(BookType.MAGAZINE);
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "16" :
                        bookFactory.getBook(BookType.NEWSPAPER);
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "17" :
                        bookRepository.removeBook(bookFactory.getBook(BookType.BOOK));
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "18" :
                        bookRepository.removeBook(bookFactory.getBook(BookType.ALBUM));
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "19" :
                        bookRepository.removeBook(bookFactory.getBook(BookType.NEWSPAPER));
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "20" :
                        bookRepository.removeBook(bookFactory.getBook(BookType.MAGAZINE));
                        bookDao.write(bookRepository.getRepository());
                        break;
                    case "21" :
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + key);
                }
            } while (!key.equals("21"));

        }

    }

}
