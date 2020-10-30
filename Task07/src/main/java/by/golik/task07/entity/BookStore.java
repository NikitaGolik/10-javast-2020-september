package by.golik.task07.entity;

import by.golik.task07.dao.BookDao;
import by.golik.task07.service.observers.Observable;
import by.golik.task07.service.observers.Observer;
import by.golik.task07.service.repository.BookRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Nikita Golik
 */
public class BookStore implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    private int countOfBooks;

    public int getCountOfBooks() {
        return countOfBooks;
    }


    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
        notifyObservers();
    }

    private static Set<Book> bookStore;


    public BookStore() throws IOException {
        BookDao bookDao = new BookDao();
        bookStore = bookDao.read();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(countOfBooks);
        }
    }
}
