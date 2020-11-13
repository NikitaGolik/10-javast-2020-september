package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class Changer {

    Lock lock = new ReentrantLock();

    public void changeElement (Element element, int valueToChange){
        lock.lock();
        if (element.getState().getClass().getSimpleName().equalsIgnoreCase("lockedstate")){
            element.setBusy(true);
            if (element.getRaw()==element.getCol()){
                try {
                    System.out.printf("Элемент i: %d, j: %d - %d заменяем на %d", element.getRaw(), element.getCol(), element.getValue(), valueToChange);
                    System.out.println();
                    element.setValue(valueToChange);
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    Logger.getLogger(Changer.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        lock.unlock();
    }
    public boolean isBusy (Element element){
        return !element.getState().getClass().getSimpleName().equalsIgnoreCase("writtenstate");
    }
}
