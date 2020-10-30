package by.golik.task07.service.query.search_query;
import by.golik.task07.entity.Book;
import by.golik.task07.service.query.BookQuery;

import java.util.ArrayList;
import java.util.Set;

/**
 * Class for search a book by author name
 */
public class SearchAuthorQuery implements BookQuery {

    private final String author;

    /**
     * specification
     * @param book - book for search
     * @return boolean true, if book of this author exists in repository
     */
    @Override
    public boolean specified(Book book) {
        return book.getAuthor().equals(author);
    }

    /**
     * constructor
     * @param author - name of author
     */
    public SearchAuthorQuery(String author) {
        this.author = author;
    }

    /**
     * method for working with specification
     * @param bookSet - set of book from file
     * @return list of books that belong to author
     */
    public ArrayList<Book> query(Set<Book> bookSet) {
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
