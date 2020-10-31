package by.golik.task07.service.query.search_query;
import by.golik.task07.entity.Book;
import by.golik.task07.service.query.BookQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class for search book by count of pages
 */
public class SearchPagesQuery implements BookQuery {
    /**
     * Specification
     * @param book - book to search
     * @return true if repository has book with entering count of pages
     */
    @Override
    public boolean specified(Book book) {
        return book.getPages() == pages;
    }

    private final int pages;

    /**
     * Constructor
     * @param identify - count of pages
     */
    public SearchPagesQuery(final int identify) {
        this.pages = identify;
    }

    /**
     * method for search book by count of pages

     * @param bookSet - set of books from repository
     * @return all books with entering count of pages
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
