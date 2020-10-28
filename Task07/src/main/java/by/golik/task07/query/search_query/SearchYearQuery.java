package by.golik.task07.query.search_query;
import by.golik.task07.entity.Book;
import by.golik.task07.query.BookQuery;
import java.util.ArrayList;
import java.util.Set;

/**
 * Class for search a book by tear of publishing
 */
public class SearchYearQuery implements BookQuery {

    private final Long year;

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
    public SearchYearQuery(Long yearToSearch) {
        this.year = yearToSearch;
    }

    /**
     * Method for search a book in file
     * @param bookSet - set of books in file
     * @return list of books by this year publishing
     */
    public ArrayList<Book> query(Set<Book> bookSet) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : bookSet) {
            if (specified(book)) {
                result.add(book);
            }
        }
        return result;
    }
}
