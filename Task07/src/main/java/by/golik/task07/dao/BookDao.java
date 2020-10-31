package by.golik.task07.dao;
import by.golik.task07.entity.Album;
import by.golik.task07.entity.Book;
import by.golik.task07.entity.Magazine;
import by.golik.task07.entity.Newspaper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author Nikita Golik
 * Class for read List of Books from file
 */

public class BookDao implements Serializable {


    public ArrayList<String> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(".\\resources\\data\\Books.txt"));

        ArrayList<String> values = new ArrayList<>();
        String line = null;
        while((line = reader.readLine()) != null) {
            values.add(line);
        }

        return values;

    }
    public Book getBookFromParams(String[] params) {

            String title = params[1];
            String author = params[2];
            int year = Integer.parseInt(params[3]);
            int pages = Integer.parseInt(params[4]);
            String[] authors = new String[params.length - 5];
            for (int i = 0; i < authors.length; i++) {
                authors[i] = params[i + 5];
            }

            if (params[0].equalsIgnoreCase("book")) {
                return new Book(title, author, year, pages);
            } else if (params[0].equalsIgnoreCase("album")) {
                return new Album(title, author, year, pages);
            } else if (params[0].equalsIgnoreCase("newspaper")) {
                return new Newspaper(title, author, year, pages);
            } else if (params[0].equalsIgnoreCase("magazine")) {
                return new Magazine(title, author, year, pages);
        } else return null;
    }

    /**
     * Method to create books
     * @param - list of books, that were added
     * @return
     */
    public ArrayList<Book> createBook(ArrayList<String> arrayList) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        for(String line : arrayList) {
            String[] params = line.split(", ");
            books.add(getBookFromParams(params));
        }
        return books;
    }


    public void write(List<Book> list) throws IOException {
      List<String> bookList = new ArrayList<>();

      for(Book book : list) {
          StringBuilder sb = new StringBuilder();
          sb.append(book.getClass().getSimpleName()).append(", ");
          sb.append(book.getTitle()).append(", ");
          sb.append(book.getAuthor()).append(", ");
          sb.append(book.getYear()).append(", ");
          sb.append(book.getPages()).append(", ");

          bookList.add(sb.substring(0,sb.length()-2).toString());
      }

        Files.write(Paths.get(".\\resources\\data\\Books.txt"), bookList, StandardOpenOption.CREATE);

      }
}
