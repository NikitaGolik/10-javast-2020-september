package by.golik.task07.service.observers;

import by.golik.task07.entity.Book;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class AlbumObserver implements Observer {


    @Override
    public void update(List<Book> list) {
        System.out.println("count of albums " + list);
    }
}
