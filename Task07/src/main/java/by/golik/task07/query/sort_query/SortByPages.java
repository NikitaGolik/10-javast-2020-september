package by.golik.task07.query.sort_query;

import by.golik.task07.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

public class SortByPages extends AbstractSortQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    public ArrayList<Book> query(Long pages, Set<Book> bookSet) {
        ArrayList<Book> bookList = new ArrayList<>(bookSet);

        Comparator<Book> bookComparator = Comparator.comparingDouble(Book::getPages);
        if (isDescending()) {
            bookComparator = bookComparator.reversed();
        }
        bookList.sort(bookComparator);
        return bookList;
    }
}
