package by.golik.jwdcourse.task06.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int year;
    private int pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }
}
