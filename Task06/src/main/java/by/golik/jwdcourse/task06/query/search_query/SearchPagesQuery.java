package by.golik.jwdcourse.task06.query.search_query;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SearchPagesQuery implements BookQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private Long pages;

    public SearchPagesQuery(final Long identify) {
        this.pages = identify;
    }

    public ArrayList<Book> query(Long pages, Set<Book> bookSet) {
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
