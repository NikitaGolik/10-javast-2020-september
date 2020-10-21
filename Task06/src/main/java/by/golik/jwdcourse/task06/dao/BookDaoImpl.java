package by.golik.jwdcourse.task06.dao;
import by.golik.jwdcourse.task06.entity.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BookDaoImpl implements BookDao, Serializable {


    @Override
    public Set<Book> readBook() throws IOException {
        Set<Book> bookSet = new HashSet<>();

        try {
            FileInputStream fis = new FileInputStream(".\\resources\\data\\Books.txt");
            ObjectInputStream o = new ObjectInputStream(fis);

            while(fis.available() > 0) {
                bookSet.add((Book) o.readObject());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bookSet;

    }

    @Override
    public void createBook(Book book) throws IOException {

        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(".\\resources\\data\\Books.txt", true), "UTF-8"));

        try {
            out.write(String.valueOf(book)+ "\n");
        } finally {
            out.close();
        }
    }
}
