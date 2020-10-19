package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchYearQuery {

    private int year;

    public SearchYearQuery(int yearToSearch) {
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
