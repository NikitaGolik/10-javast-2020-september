package by.golik.jwdcourse.task06.controller;
import by.golik.jwdcourse.task06.dao.Tag;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;
import by.golik.jwdcourse.task06.view.Menu;
import java.io.IOException;
import java.util.Scanner;

public class Controller {

    Book book;
    BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    Menu menu = new Menu();
    private Scanner scanner;

    public Controller(Scanner scanner) throws IOException {
        this.scanner = scanner;
    }

        public void start() throws BookAlreadyHaveException {
            if (this.scanner != null) {
                String key;
                do {
                    menu.printMenu();
                    System.out.println("Введите номер меню: ");
                    key = this.scanner.nextLine();
                    switch (key) {
                        case "1" :
                            bookRepository.finByTag(Tag.AUTHOR);
                            break;
                        case "2" :
                            bookRepository.finByTag(Tag.TITLE);
                            break;
                        case "3" :
                            bookRepository.finByTag(Tag.PAGES);
                            break;
                        case "4" :
                            bookRepository.finByTag(Tag.YEAR);
                            break;
                        case "5" :
                            bookRepository.sortByTag(Tag.AUTHOR);
                            break;
                        case "6" :
                            bookRepository.sortByTag(Tag.TITLE);
                            break;
                        case "7" :
                            bookRepository.sortByTag(Tag.PAGES);
                            break;
                        case "8" :
                            bookRepository.sortByTag(Tag.YEAR);
                            break;
                        case "9" :
                            bookRepository.addBook(new Book("Маленький принц", "Экзюпери", 20, 20));
                            break;
                        case "10" :

                            break;
                        case "11" :
                            System.out.println("Завершение программы");
                            break;
                        default :
                            System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                    }
                } while (!key.equals("12"));
            }
        }
}

