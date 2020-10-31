package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Query for searching objects by name...*/

public class SearchTitleQuery implements BookQuery {

    @Override
    public boolean specified(Book book) {
        return book.getTitle().equals(title);
    }

    private final String title;

    public SearchTitleQuery(String titleToSearch) {
        this.title = titleToSearch;
    }

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
