package by.golik.task07.service.observers;

import by.golik.task07.entity.Book;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class NewspaperObserver implements Observer {


    @Override
    public void update(List<Book> newspapers) {
        System.out.println("count of newspapers " + newspapers);
    }
}
