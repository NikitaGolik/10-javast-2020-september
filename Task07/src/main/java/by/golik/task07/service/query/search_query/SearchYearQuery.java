package by.golik.task07.service.query.search_query;
import by.golik.task07.entity.Book;
import by.golik.task07.service.query.BookQuery;
import java.util.ArrayList;
import java.util.List;

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
     * @param bookSet - list of books in file
     * @return list of books by this year publishing
     */
    public ArrayList<Book> query(List<Book> bookSet) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : bookSet) {
            if (specified(book)) {
                result.add(book);
            }
        }
        System.out.println(result);
        return result;
    }
}
