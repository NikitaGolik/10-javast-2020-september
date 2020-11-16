package by.golik.task08threads.service.threads;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.MatrixAsList;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.service.state.WrittenState;
import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class ThreadThree implements Runnable {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ThreadThree.class);

    public static final int NUMBER_FOUR = 444;

    private final int value;
    MatrixAsList matrixAsList;
    Semaphore matrixSemaphore;
    String name;


    public ThreadThree(Semaphore matrixSemaphore, String name, MatrixAsList matrixAsList, int value) {
        this.matrixSemaphore = matrixSemaphore;
        this.name = name;
        this.matrixAsList = matrixAsList;
        this.value = value;
    }

    @Override
    public void run() {
        for (Element element : matrixAsList.getMatrixTable())
            try {
                System.out.println(name + " ожидает разрешение");
                logger.info(name + " ожидает разрешение");
                matrixSemaphore.acquire();
                    element.setBusy(true);
                    if (element.getRaw() == element.getCol()) {
                        element.setValue(value);
                        element.changeState(new WrittenState());

                        TimeUnit.MILLISECONDS.sleep(100);
                       logger.info("Меняем " + element.getRaw() + " " + element.getCol() + " на " + element.getValue());
                    }
                    matrixSemaphore.release();

            } catch (InterruptedException e) {
                Logger.getLogger(ThreadThree.class.getName()).log(Level.SEVERE, null, e);
                System.out.println(name + " освобождает разрешение");
                logger.info(name + " освобождает разрешение");
            }
    }
}