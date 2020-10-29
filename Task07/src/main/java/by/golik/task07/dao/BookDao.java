package by.golik.task07.dao;
import by.golik.task07.entity.Book;
import by.golik.task07.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Nikita Golik
 * Class for read List of Books from file
 */

public class BookDao implements Serializable {
    private static final Logger logger = LogManager.getLogger(BookDao.class);

    public Set<Book> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(".\\resources\\data\\Books.txt"));

        ArrayList<String> values = new ArrayList<>();
        Set<Book> bookSet = new HashSet<>();

        String line = null;
        while((line = reader.readLine()) != null) {
            values.add(line);
        }
        System.out.println(values);

        for(int i = 0; i < values.size(); i+=4) {
            Book book = new Book(values.get(i),values.get(i+1),Integer.parseInt(values.get(i+2)),
                    Integer.parseInt(values.get(i+3)));
            bookSet.add(book);
        }

        System.out.println(bookSet);
        return  bookSet;
    }



    public void write(Set<Book> books) throws FileNotFoundException {
      FileOutputStream fos = new FileOutputStream(".\\resources\\data\\NewBooks.txt", true);
      PrintWriter writer = new PrintWriter(fos);
      writer.write(String.valueOf(books));
      writer.close();

    }

    /**
     * Class for reading books from file
     * @return Set of books from file
     * @throws IOException
     */

    public Set<Book> readBook() throws IOException {
        Set<Book> bookSet = new HashSet<>();

        try( FileInputStream fis = new FileInputStream(".\\resources\\data\\Books.txt");
             ObjectInputStream o = new ObjectInputStream(fis)) {


            logger.warn("Something to warn");
            logger.error("Error with read object.");
            logger.fatal("Ошибка при сериализации нового списка объектов");


            while(fis.available() > 0) {
                Book book = (Book) o.readObject();
                bookSet.add(book);

            }
        } catch (EOFException | ClassNotFoundException | StreamCorruptedException e) {
            System.out.println("Bad inputStream");
        }
        System.out.println(bookSet);
        return bookSet;
    }

    /**
     * Method to create books
     * @param - list of books, that were added
     */
    public void createBook(Set<Book> repository) {

        try(FileOutputStream fos = new FileOutputStream(".\\resources\\data\\NewBooks.txt", true);
            ObjectOutputStream serial = new ObjectOutputStream(fos)) {


            logger.warn("Something to warn");
            logger.error("failed with write object.");
            logger.fatal("Fatal with write object");


            for(Book book : repository) {
                serial.writeObject(book);
            }

        } catch (Exception ex) {
            System.out.println("Ошибка при сериализации объекта");
            ex.printStackTrace();
        }
    }
}
