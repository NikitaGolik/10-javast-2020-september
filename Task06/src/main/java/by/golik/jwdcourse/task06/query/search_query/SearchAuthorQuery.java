package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SearchAuthorQuery implements BookQuery {

    private final String author;

    @Override
    public boolean specified(Book book) {
        return false;
    }
    public SearchAuthorQuery(String author) {
        this.author = author;
    }

    public ArrayList<Book> query(String author, Set<Book> bookSet) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : bookSet) {
            if (specified(book)) {
                result.add(book);
            }
        }
        System.out.println(result.toString());
        return result;
    }
}
