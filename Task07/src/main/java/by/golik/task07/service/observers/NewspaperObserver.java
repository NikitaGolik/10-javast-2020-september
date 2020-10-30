package by.golik.task07.service.observers;

/**
 * @author Nikita Golik
 */
public class NewspaperObserver implements Observer {

    private int countBooks;

    public int getCountBooks() {
        return countBooks;
    }

    @Override
    public void update(int countOfBooks) {
        countBooks = countOfBooks;
    }
}
