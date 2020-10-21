package by.golik.jwdcourse.task06.query.search_query;
import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchPagesQuery implements BookQuery {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private Long pages;

    public SearchPagesQuery(final Long identify) {
        this.pages = identify;
    }


    public ArrayList<Book> query(Long pages, ArrayList<Book> books) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPages() == this.pages) {
                result.add(book);
            }
        }

        return result;
    }
}
