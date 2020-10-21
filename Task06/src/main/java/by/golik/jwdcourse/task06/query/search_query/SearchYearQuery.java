package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SearchYearQuery implements BookQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final Long year;

    public SearchYearQuery(Long yearToSearch) {
        this.year = yearToSearch;
    }

    public ArrayList<Book> query(Long year, Set<Book> bookSet) {
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
