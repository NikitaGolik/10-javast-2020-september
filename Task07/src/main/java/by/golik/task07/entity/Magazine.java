package by.golik.task07.entity;

/**
 * @author Nikita Golik
 */
public class Magazine extends Book {

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }

    @Override
    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public int getPages() {
        return super.getPages();
    }

    @Override
    public void setPages(int pages) {
        super.setPages(pages);
    }

    public Magazine(String title, String author, int year, int pages) {
        super(title, author, pages, year);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
