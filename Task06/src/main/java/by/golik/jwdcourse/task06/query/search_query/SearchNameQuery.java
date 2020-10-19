package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

/** Query for searching objets by name...*/

public class SearchNameQuery implements BookQuery {

    private String name;

    public SearchNameQuery(String nameToSearch) {
        this.name = nameToSearch;
    }
    public ArrayList<Book> query(HashMap<Book, BookRepositoryImpl> storage) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : storage.keySet()) {
            if (book.getName().equals(this.name)) {
                result.add(book);
            }
        } return result;
    }
}
