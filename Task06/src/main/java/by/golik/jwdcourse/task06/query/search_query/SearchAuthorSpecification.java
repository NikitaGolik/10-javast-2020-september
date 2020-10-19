package by.golik.jwdcourse.task06.query.search_query;

import by.golik.jwdcourse.task06.entity.Book;
import by.golik.jwdcourse.task06.query.BookSpecification;
import by.golik.jwdcourse.task06.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchAuthorSpecification implements BookSpecification {

    @Override
    public boolean specified(Book book) {
        return false;
    }

    private final String author;

    public SearchAuthorSpecification(String authorToSearch)  {
        this.author = authorToSearch;
    }

    public ArrayList<Book> query(HashMap<Book, BookRepositoryImpl> storage) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : storage.keySet()) {
            if (book.getAuthor().equals(this.author)) {
                result.add(book);
            }
        } return result;
    }

}
