package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookSpecification;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchYearSpecification implements BookSpecification {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final int year;

    public SearchYearSpecification(final int yearToSearch) {
        this.year = yearToSearch;
    }

    public ArrayList<Book> query(HashMap<Book, BookRepositoryImpl> storage) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : storage.keySet()) {
            if(book.getYear() == this.year) {
                result.add(book);
            }
        } return result;
    }
}
