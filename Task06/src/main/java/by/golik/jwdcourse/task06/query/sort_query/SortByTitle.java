package by.golik.jwdcourse.task06.query.sort_query;

import by.golik.jwdcourse.task06.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class SortByTitle extends AbstractSortQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    public ArrayList<Book> query(HashMap<Book, ArrayList<Book>> list) {
        ArrayList<Book> bookList = new ArrayList<>(list.keySet());
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
        if(isDescending()) {
            comparator = comparator.reversed();
        }
        bookList.sort(comparator);
        return bookList;
    }
}
