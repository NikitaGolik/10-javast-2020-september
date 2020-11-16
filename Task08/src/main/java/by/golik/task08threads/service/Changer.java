package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.service.state.WrittenState;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class Changer {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Changer.class);
    Lock lock = new ReentrantLock();


    /**
     * method, that changes element of matrix diagonal to static value of thread
     * @param element - element of matrix
     * @param valueToChange - static int value from thread
     */
    public void changeElement (Element element, int valueToChange){

        lock.lock();
        if (!element.getState().getClass().getSimpleName().equalsIgnoreCase("LockedState")){
            element.setBusy(true);
            if (element.getRaw()==element.getCol() && !element.getState().getClass().getSimpleName().equalsIgnoreCase("LockedState")){
                try {
                    System.out.printf("Элемент столбец: %d, строка: %d - %d меняем на %d", element.getRaw(),
                            element.getCol(), element.getValue(), valueToChange);
                    logger.info("Элемент столбец: " + element.getRaw() + " строка " + element.getCol() +
                            " старое значение " + element.getValue() + " новое значение " + valueToChange);

                    System.out.println();
                    element.setValue(valueToChange);
                    element.changeState(new WrittenState());

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
