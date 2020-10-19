package by.golik.jwdcourse.task06.entity;

public class Book {
    private String name;
    private String author;
    private int pages;
    private int year;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book(String name, String author, int pages, int year, int id) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.year = year;
        setId(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                ", id=" + id +
                '}';
    }
}
