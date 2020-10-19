package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookSpecification;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

/** Query for searching objets by name...*/

public class SearchNameSpecification implements BookSpecification {
    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final String name;

    public SearchNameSpecification(String nameToSearch) {
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
