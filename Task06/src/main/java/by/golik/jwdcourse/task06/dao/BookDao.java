package by.golik.jwdcourse.task06.dao;
import by.golik.jwdcourse.task06.entity.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BookDao implements Serializable {


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
