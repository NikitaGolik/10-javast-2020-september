package by.golik.jwdcourse.task06.query.sort_query;
import by.golik.jwdcourse.task06.entity.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

public class SortByAuthor extends AbstractSortQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    public ArrayList<Book> query(ArrayList<Book> bookSet) {
        ArrayList<Book> bookList = new ArrayList<>(bookSet);

        Comparator<Book> bookComparator = Comparator.comparing(Book::getAuthor);
        if (isDescending()) {
            bookComparator = bookComparator.reversed();
        }
        bookList.sort(bookComparator);
        return bookList;
    }

}
