package by.golik.jwdcourse.task06.dao;
import by.golik.jwdcourse.task06.entity.Book;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


public interface BookDao {

    HashMap<String, String> map = new HashMap<>();

    Set<Book> readBook() throws IOException, ClassNotFoundException;

    void createBook (Book book) throws IOException;



}
