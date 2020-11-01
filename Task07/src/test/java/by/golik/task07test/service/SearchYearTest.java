package by.golik.task07test.service;

import by.golik.task07.entity.Album;
import by.golik.task07.entity.Book;
import by.golik.task07.entity.Newspaper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class SearchYearTest {


    @DataProvider(name = "dataToSearch")
    public Object[][] createDataForSearch() {
        return
                new Object[][] {
                        {new Book("Преступление и наказание", "Достоевский", 1993, 190)},
                        {new Album("Пароход", "Голик", 2000, 200)},
                        {new Newspaper("Солнце", "Петров", 1985, 300)}
                };
    }

    @Test(description = "searchInBooklistScenary", dataProvider = "dataToSearch")
    public void testSearch(List<Book> args) {


    }
}
