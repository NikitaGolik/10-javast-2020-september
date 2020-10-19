package by.golik.jwdcourse.task06.query.sort_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class SortByYear extends AbstractSortSpecification {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    public ArrayList<Book> query(HashMap<Book, BookRepositoryImpl> storage) {
        ArrayList<Book> bookList = new ArrayList<>(storage.keySet());
        Comparator<Book> comparator = Comparator.comparing(Book::getYear);
        if(isDescending()) {
            comparator = comparator.reversed();
        }
        bookList.sort(comparator);
        return bookList;
    }
}
