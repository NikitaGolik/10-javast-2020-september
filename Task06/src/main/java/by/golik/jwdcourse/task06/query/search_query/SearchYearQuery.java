package by.golik.jwdcourse.task06.query.search_query;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import java.util.ArrayList;
import java.util.Set;

/**
 * Class for search a book by tear of publishing
 */
public class SearchYearQuery implements BookQuery {

    private final int year;

    /**
     * Specification
     * @param book - book for search
     * @return true if repository has a book by this year
     */
    @Override
    public boolean specified(Book book) {
        return book.getYear() == year;
    }

    /**
     * Constructor
     * @param yearToSearch - entering year for search
     */
    public SearchYearQuery(int yearToSearch) {
        this.year = yearToSearch;
    }

    /**
     * Method for search a book in file

     * @param bookSet - set of books in file
     * @return list of books by this year publishing
     */
    public ArrayList<Book> query(ArrayList<Book> bookSet) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : bookSet) {
            if (specified(book)) {
                result.add(book);
            }
        }
        return result;
    }
}
