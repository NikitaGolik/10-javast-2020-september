package by.golik.task07.dao;
import by.golik.task07.entity.Album;
import by.golik.task07.entity.Book;
import by.golik.task07.entity.Magazine;
import by.golik.task07.entity.Newspaper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author Nikita Golik
 * Class for read and write List of Books from file
 */

public class BookDao implements Serializable {

    /**
     * Read books from txt file to list of <String> Books
     * @return list of books from file
     */
    public ArrayList<String> read() {
        ArrayList<String> values = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\resources\\data\\Books.txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                values.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error with inputStream");
            e.printStackTrace();
        }
        return values;
    }

    /**
     * Create Book from String params
     * @param fields - fields of book(title, author, year, pages)
     * @return new Book, creating from text file
     */
    public Book getFieldsForBook(String[] fields) {

            String title = fields[1];
            String author = fields[2];
            int year = Integer.parseInt(fields[3]);
            int pages = Integer.parseInt(fields[4]);
            String[] authors = new String[fields.length - 5];
            for (int i = 0; i < authors.length; i++) {
                authors[i] = fields[i + 5];
            }

            if (fields[0].equalsIgnoreCase("book")) {
                return new Book(title, author, year, pages);
            } else if (fields[0].equalsIgnoreCase("album")) {
                return new Album(title, author, year, pages);
            } else if (fields[0].equalsIgnoreCase("newspaper")) {
                return new Newspaper(title, author, year, pages);
            } else if (fields[0].equalsIgnoreCase("magazine")) {
                return new Magazine(title, author, year, pages);
        } else return null;
    }

    /**
     * Create list of books from objectes, that were created
     * @param arrayList - list of fields of books from file
     * @return list of created books
     * @throws IOException
     */
    public ArrayList<Book> createBook(ArrayList<String> arrayList) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        for(String line : arrayList) {
            String[] params = line.split(", ");
            books.add(getFieldsForBook(params));
        }
        return books;
    }

    /**
     *  Add books to .txt file
     * @param list - list of books to write to .txt file
     * @throws IOException
     */

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
