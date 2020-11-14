package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.service.state.WrittenState;

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

    /**
     * method, that changes element of matrix diagonal to static value of thread
     * @param element - element of matrix
     * @param valueToChange - static int value from thread
     */
    public void changeElement (Element element, int valueToChange){

        if (!element.getState().getClass().getSimpleName().equalsIgnoreCase("LockedState")){
            lock.lock();
            element.setBusy(true);
            if (element.getRaw()==element.getCol()){
                try {
                    System.out.printf("Элемент строка: %d, столбец: %d - %d меняем на %d", element.getRaw(),
                            element.getCol(), element.getValue(), valueToChange);

                    System.out.println();
                    element.setValue(valueToChange);
                    element.changeState(new WrittenState(element));
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    Logger.getLogger(Changer.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        lock.unlock();
    }
    public boolean isBusy (Element element){
        return !element.getState().getClass().getSimpleName().equalsIgnoreCase("LockedState");
    }
}
