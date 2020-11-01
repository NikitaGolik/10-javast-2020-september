package by.golik.task07.service.query.sort_query;
import by.golik.task07.entity.Book;
import by.golik.task07.service.query.AbstractSortQuery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class SortByPagesThenYear extends AbstractSortQuery {
    /**
     *
     * @param book which will be compared
     * @return boolean result false
     */
    @Override
    public boolean specified(Book book) {
        return false;
    }

    /**
     *
     * @param bookSet - list of books to sort by count of pages, than by year of publishing
     * @return sorted booklist
     */
    public ArrayList<Book> query(List<Book> bookSet) {
        ArrayList<Book> bookList = new ArrayList<>(bookSet);

        Comparator<Book> bookComparator = Comparator.comparingDouble(Book::getPages).thenComparing(Book::getYear);
        if (isDescending()) {
            bookComparator = bookComparator.reversed();
        }
        bookList.sort(bookComparator);
        System.out.println(bookList);
        return bookList;
    }
}
