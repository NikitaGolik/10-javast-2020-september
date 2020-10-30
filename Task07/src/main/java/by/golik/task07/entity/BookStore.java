package by.golik.task07.entity;
import by.golik.task07.dao.BookDao;
import by.golik.task07.service.observers.Observable;
import by.golik.task07.service.observers.Observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Nikita Golik
 */
public class BookStore implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public BookStore() throws IOException {
        BookDao bookDao = new BookDao();
        this.bookList = new ArrayList<>(bookDao.read());
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
//        for(Observer observer : observers) {
//            observer.update(countOfAlbums());
//            observer.update(countOfMagazines());
//            observer.update(countOfNewspapers());
//        }
    }
    public int countOfAlbums() {
        int countOfAlbums = 0;
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i) instanceof Album) {
                countOfAlbums++;
            }
        }
        notifyObservers();
        System.out.println("Count of albums " + countOfAlbums);
        return countOfAlbums;
    }

    public int countOfNewspapers() {
        int countOfNewspapers = 0;
        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i) instanceof Newspaper) {
                countOfNewspapers++;
            }
        }
        notifyObservers();
        System.out.println("Count of newspapers " + countOfNewspapers);
        return countOfNewspapers;
    }

    public int countOfMagazines() {
        int countOfMagazines = 0;
        for(int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) instanceof Magazine) {
                countOfMagazines++;
            }
        }
        notifyObservers();
        System.out.println("Count of magazines " + countOfMagazines);
        return countOfMagazines;
    }
}
