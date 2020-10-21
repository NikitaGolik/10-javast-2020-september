package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchYearQuery implements BookQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final int year;

    public SearchYearQuery(final int yearToSearch) {
        this.year = yearToSearch;
    }

    public ArrayList<Book> query(Long year, ArrayList<Book> books) {
        ArrayList<Book> result = new ArrayList<>();

        for(Book book : books) {
            if(book.getYear() == this.year) {
                result.add(book);
            }
        } return result;
    }
}
