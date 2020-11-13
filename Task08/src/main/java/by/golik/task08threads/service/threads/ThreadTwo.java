package by.golik.task08threads.service.threads;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.MatrixAsList;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.beans.Element;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class ThreadTwo extends  Thread {

    private static final int NUMBER_THREE = 333;
    Changer changer;
    Element element;
    private List<Element> elementList;

    private static final Logger logger = Logger.getLogger(ThreadTwo.class.getName());



    public ThreadTwo(List<Element> elementList, Changer changer) {
        this.elementList = elementList;
        this.changer = changer;
    }

    @Override
    public void run() {

        for (int i = 0; i < elementList.size(); i++) {
            element = elementList.get(i);
            logger.info(String.valueOf(element.getCol()) + " " + String.valueOf(element.getRaw()) +
                    " " + String.valueOf(element.getValue()));
        }
        if (!changer.isBusy(element)) {
            changer.changeElement(element, NUMBER_THREE);
            logger.info(String.valueOf(element.getCol()) + " " + String.valueOf(element.getRaw()) +
                    " " + String.valueOf(element.getValue()));

        }
    }
}