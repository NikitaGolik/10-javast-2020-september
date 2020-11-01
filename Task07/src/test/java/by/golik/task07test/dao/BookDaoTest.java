package by.golik.task07test.dao;

import by.golik.task07.dao.BookDao;
import by.golik.task07.entity.Book;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class BookDaoTest {
    BookDao bookDao = new BookDao();

    @DataProvider(name = "dataFromFile")
    public Object[] createDataFromFile() {
        return new Object[] {
                "Book, Преступление и наказание, Достоевский, 1993, 190"
        };
    }

    @Test(description = "readFromFileScenary", dataProvider = "dataFromFile")
    public void testRead(String[] args) throws IOException {
        List<String> list = bookDao.read();
        Assert.assertEquals(list.get(0), args[0]);
    }

    @DataProvider(name = "createDataToCreateBookFromDataFromFile")
    public Object[] createDataToCreateBookFromDataFromFile() {
        return new Object[] {
                "Book, Преступление и наказание, Достоевский, 1993, 190"
        };
    }

    @Test(description = "createBook", dataProvider = "createDataToCreateBookFromDataFromFile")
    public void testCreate(Book book, ArrayList<Book> expected) throws IOException {

        ArrayList<Book> actual = bookDao.createBook(bookDao.read());

        Assert.assertEquals(actual, expected);
    }
}
