package by.golik.jwdcourse.task06.query.search_query;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookSpecification;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchIdSpecification implements BookSpecification {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final long id;

    public SearchIdSpecification(final long identify) {
        this.id = identify;
    }


    public ArrayList query(HashMap<Book, BookRepositoryImpl> storage) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : storage.keySet()) {
            if (book.getId() == this.id) {
                result.add(book);
            }
        } return result;
    }
}
