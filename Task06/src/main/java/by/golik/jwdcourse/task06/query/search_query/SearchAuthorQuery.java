package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchAuthorQuery implements BookQuery {

    private final String author;

    @Override
    public boolean specified(Book book) {
        return false;
    }
    public SearchAuthorQuery(String author) {
        this.author = author;
    }

    public static List<Book> booksByPublisher(String author, ArrayList<Book> books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                result.add(book);
            }
        }

        return result;
    }
}
