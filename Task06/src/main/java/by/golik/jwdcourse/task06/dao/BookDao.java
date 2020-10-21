package by.golik.jwdcourse.task06.dao;
import by.golik.jwdcourse.task06.entity.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nikita Golik
 * Class for read List of Books from file
 */

public class BookDao implements Serializable {

    /**
     * Class for reading books from file
     * @return Set of books from file
     * @throws IOException
     */

    public Set<Book> readBook() throws IOException {
        Set<Book> bookSet = new HashSet<>();


        try( FileInputStream fis = new FileInputStream(".\\resources\\data\\Books.txt");
             ObjectInputStream o = new ObjectInputStream(fis)) {

            while(fis.available() > 0) {
                Book book = (Book) o.readObject();
                bookSet.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(bookSet);
        return bookSet;
    }

    /**
     * Mthod to create books
     * @param bookArrayList - list of books, that were added
     * @throws IOException
     */
    public void createBook(ArrayList<Book> bookArrayList) throws IOException {

        try(FileOutputStream fo = new FileOutputStream(".\\resources\\data\\Books.txt", true);
            ObjectOutputStream serial = new ObjectOutputStream(fo)) {

            for(Book book : bookArrayList) {
                serial.writeObject(book);
            }

        } catch (Exception ex) {
            System.out.println("Ошибка при сериализации объекта");
            ex.printStackTrace();
        }
    }

}
