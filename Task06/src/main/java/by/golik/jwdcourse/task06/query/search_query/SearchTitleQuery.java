package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;

import java.util.ArrayList;
import java.util.List;

/** Query for searching objects by name...*/

public class SearchTitleQuery implements BookQuery {
    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final String title;

    public SearchTitleQuery(String titleToSearch) {
        this.title = titleToSearch;
    }

    public static List<Book> booksByTitle(String title, ArrayList<Book> books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (title.equals(book.getTitle())) {
                result.add(book);
            }
        }
        System.out.println(result.toString());
        return result;
    }
}
