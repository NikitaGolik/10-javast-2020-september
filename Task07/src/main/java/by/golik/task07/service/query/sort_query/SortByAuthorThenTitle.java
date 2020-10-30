package by.golik.task07.service.query.sort_query;

import by.golik.task07.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/**
 * @author Nikita Golik
 */
public class SortByAuthorThenTitle extends AbstractSortQuery {
    @Override
    public boolean specified(Book book) {
        return false;
    }

    public ArrayList<Book> query(Set<Book> bookSet) {
        ArrayList<Book> bookList = new ArrayList<>(bookSet);

        Comparator<Book> bookComparator = Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle);
        if (isDescending()) {
            bookComparator = bookComparator.reversed();
        }
        bookList.sort(bookComparator);

        System.out.println(bookList);

        return bookList;
    }
}
