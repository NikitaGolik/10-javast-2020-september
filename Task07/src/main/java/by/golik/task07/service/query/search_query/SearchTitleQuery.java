package by.golik.task07.service.query.search_query;
import by.golik.task07.entity.Book;
import by.golik.task07.service.query.BookQuery;
import java.util.ArrayList;
import java.util.List;


/** Query for searching objects by name...*/

public class SearchTitleQuery implements BookQuery {

    /**+
     * Specification
     * @param book - book to search
     * @return true if repository has book with entering title
     */
    @Override
    public boolean specified(Book book) {
        return book.getTitle().equals(title);
    }

    private final String title;

    /**
     *
     * @param titleToSearch
     */
    public SearchTitleQuery(String titleToSearch) {
        this.title = titleToSearch;
    }

    /**
     *
     * @param bookSet - list of books from repository
     * @return list of books by this title
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
