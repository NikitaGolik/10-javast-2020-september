package by.golik.task08threads.service.threads;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.beans.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Nikita Golik
 */
public  class ThreadOne extends Thread {

    public static final int NUMBER_TWO = 222;

    private static final Logger logger = LogManager.getLogger(ThreadOne.class);

    Changer changer;
    Element element;
    private List<Element> elementList;

    public ThreadOne(List<Element> elementList, Changer changer) {
        this.elementList = elementList;
        this.changer = changer;
    }

    @Override
    public void run() {

        for (int i = 0; i < elementList.size(); i++) {
            element = elementList.get(i);
            logger.info(currentThread().getName() + " Элемент " + String.valueOf(element.getCol()) + " столбец " + "  " +
                    String.valueOf(element.getRaw()) + " строка" +
                    " имеет значение " + String.valueOf(element.getValue()));

        if (changer.isBusy(element)) {
            changer.changeElement(element, NUMBER_TWO);

            logger.info(String.valueOf(element.getCol()) + " " + String.valueOf(element.getRaw()) +
                    " " + String.valueOf(element.getValue()));
            }
        }

    }

}
