package by.golik.task07.service.observers;

/**
 * @author Nikita Golik
 */
public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
