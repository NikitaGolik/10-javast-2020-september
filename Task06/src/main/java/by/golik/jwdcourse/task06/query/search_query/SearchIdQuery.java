package by.golik.jwdcourse.task06.query.search_query;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchIdQuery implements BookQuery {
    private int id;

    public SearchIdQuery(int identify) {
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
