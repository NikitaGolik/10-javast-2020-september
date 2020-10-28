package by.golik.task07.entity;
import java.io.Serializable;

/**
 * Class for creating entity of Book
 */
public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private int year;
    private int pages;



    /**
     * getter for title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter for title
     * @param title of book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter for author of book
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setter for author
     * @param author of book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * getter for year of book
     * @return year of publishing
     */
    public int getYear() {
        return year;
    }

    /**
     * setter for year
     * @param year of publishing book
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * getter for pages
     * @return count of pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * setter for pages
     * @param pages count of pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * create book with :
     * @param title - title of book
     * @param author - author of book
     * @param pages - count of pages in book
     * @param year - year of publishing book
     */
    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    /**
     *
     * @return string result of book
     */
    @Override
    public String toString() {
        return "Book{" +
                "id =" + id +'\'' +
                "name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }
}
