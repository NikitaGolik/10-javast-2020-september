package by.golik.task07.controller;
import by.golik.task07.dao.BookDao;
import by.golik.task07.dao.Tag;
import by.golik.task07.entity.Book;
import by.golik.task07.exceptions.BookAlreadyHaveException;
import by.golik.task07.exceptions.BookNotExistException;
import by.golik.task07.repository.BookRepositoryImpl;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    public Controller() throws IOException {
    }

//    BookDao bookDao = new BookDao();
//    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

//    public void create() {
//        ArrayList<Book> books = new ArrayList<>();
//        Book book1 = new Book("Java", "Nikolai", 150, 1993);
//        Book book2 = new Book("Python", "Masha", 200, 2000);
//        Book book3 = new Book("JavaScript", "Aleksandr", 130, 2015);
//        Book book4 = new Book("HTML", "Petr", 230, 2020);
//        Book book5 = new Book("CSS", "Vladimir", 350, 1985);
//
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//        books.add(book4);
//        books.add(book5);
//
//        bookDao.createBook(books);
//    }
//    public void find() {
//        bookRepository.finByTag(Tag.TITLE);
//        bookRepository.finByTag(Tag.AUTHOR);
//        bookRepository.finByTag(Tag.PAGES);
//        bookRepository.finByTag(Tag.YEAR);
//
//    }
//    public void sort() {
//        bookRepository.sortByTag(Tag.TITLE);
//        bookRepository.sortByTag(Tag.AUTHOR);
//        bookRepository.sortByTag(Tag.PAGES);
//        bookRepository.sortByTag(Tag.YEAR);
//    }
//    public void add() throws BookAlreadyHaveException {
//        bookRepository.addBook(new Book("Factory", "Mike", 150,300));
//    }
//
//    public void remove() throws BookNotExistException {
//        bookRepository.removeBook(new Book("Python", "Masha", 200, 2000));
//    }
}
