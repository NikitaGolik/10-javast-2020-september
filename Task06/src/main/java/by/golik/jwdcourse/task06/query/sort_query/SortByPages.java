package by.golik.jwdcourse.task06.query.sort_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class SortByPages extends AbstractSortQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    public ArrayList<Book> query(Long pages, ArrayList<Book> books) {
        ArrayList<Book> bookList = new ArrayList<>();
        Comparator<Book> comparator = Comparator.comparing(Book::getPages);
        if(isDescending()) {
            comparator = comparator.reversed();
        }
        bookList.sort(comparator);
        return bookList;
    }
}
