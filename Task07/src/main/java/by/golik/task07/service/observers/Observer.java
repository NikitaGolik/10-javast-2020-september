package by.golik.task07.service.observers;

import by.golik.task07.entity.Book;

import java.util.List;

/**
 * @author Nikita Golik
 */
public interface Observer {
    void update(List<Book> list);
}
