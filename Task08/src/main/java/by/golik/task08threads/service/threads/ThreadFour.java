package by.golik.task08threads.service.threads;


import by.golik.task08threads.beans.Element;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.service.state.WrittenState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.Phaser;

/**
 * @author Nikita Golik
 */
public class ThreadFour extends Thread {
    public static final int NUMBER_Four = 111;

    private static final Logger logger = LogManager.getLogger(ThreadOne.class);

    Changer changer;
    Element element;
    private List<Element> elementList;
    Phaser phaser;
    private String name;

    public ThreadFour(Phaser phaser, String name, List<Element> elementList, Changer changer) {
        this.phaser = phaser;
        this.name = name;
        this.elementList = elementList;
        this.changer = changer;
    }

    @Override
    public void run() {

        phaser.register();

        System.out.println(name + "  выполняет фазу " + phaser.getPhase());
        logger.info(name + " выполняет фазу " + phaser.getPhase());

        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < elementList.size(); i++) {
            element = elementList.get(i);
            logger.info(currentThread().getName() + " Элемент " + String.valueOf(element.getCol()) + " столбец " + "  " +
                    String.valueOf(element.getRaw()) + " строка" +
                    " имеет значение " + String.valueOf(element.getValue()));

            if (changer.isBusy(element)) {

                changer.changeElement(element, NUMBER_Four);
                element.changeState(new WrittenState(element));
                System.out.println(name + " выполняет фазу " + phaser.getPhase());
                logger.info(name + " выполняет фазу " + phaser.getPhase());
                phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
                try{
                    Thread.sleep(200);
                }
                catch(InterruptedException ex){
                    System.out.println(ex.getMessage());
                }

                logger.info(String.valueOf(element.getCol()) + " " + String.valueOf(element.getRaw()) +
                        " " + String.valueOf(element.getValue()));
                System.out.println(name + " выполняет фазу " + phaser.getPhase());
                phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
            }
        }
    }

}
