package by.golik.task07.service.query.search_query;

import by.golik.task07.entity.Book;
import by.golik.task07.service.query.BookQuery;

import java.util.ArrayList;
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
