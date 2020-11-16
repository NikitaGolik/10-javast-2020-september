package by.golik.task08threads.controller;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.MatrixAsList;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.service.CollectionTransformer;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.service.threads.ThreadFour;
import by.golik.task08threads.service.threads.ThreadOne;
import by.golik.task08threads.service.threads.ThreadThree;
import by.golik.task08threads.service.threads.ThreadTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Nikita Golik
 */
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    public static void main(String[] args) throws Exception {

        logger.info("Start Main");

        /** create matrix */
        MatrixCreator matrixCreator = new MatrixCreator();
        Matrix matrix;
        matrix = matrixCreator.fillFromFile();

        /** integer list */
        List<Integer> integers;
        integers = matrix.convert(matrix);
        System.out.println(integers);

        CollectionTransformer collectionTransformer = new CollectionTransformer();

        /** integer list */
        List<Element> elements;
        elements = collectionTransformer.transform(matrix.convert(matrix));

        System.out.println(elements);
        Changer changer = new Changer();



        /** (1) */

        ThreadOne threadOne = new ThreadOne(elements, changer);
        ThreadTwo threadTwo = new ThreadTwo(elements, changer);

        //todo try/catch

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            logger.error("Interrupted Error");
        }

        for(Element element : elements) {
            System.out.println(element.toString());
        }

        List<Integer> integers2;
        integers2 = matrixCreator.createListIntegerFromElements(elements);

        int[] array = matrixCreator.createFromListToArray(integers2);

        matrixCreator.createFromArrayToMatrix(array);


        /** (2) */

//        ExecutorService es = Executors.newFixedThreadPool(2);
//        es.execute(new ThreadOne(elements,changer));
//        es.execute(new ThreadTwo(elements,changer));
//
//        es.shutdown();
//
//        List<Integer> integers2;
//        integers2 = matrixCreator.createListIntegerFromElements(elements);
//
//        int[] array = matrixCreator.createFromListToArray(integers2);
//
//        matrixCreator.createFromArrayToMatrix(array);


        /** (3) */

//        MatrixAsList matrixAsList = new MatrixAsList(elements);
//
//        Semaphore matrixSemaphore = new Semaphore(1);
//
//        new Thread(new ThreadThree(matrixSemaphore, "thread1",matrixAsList, ThreadThree.NUMBER_FOUR)).start();
//        new Thread(new ThreadThree(matrixSemaphore, "thread2", matrixAsList, ThreadOne.NUMBER_TWO)).start();
//
//        List<Integer> integers2;
//        integers2 = matrixCreator.createListIntegerFromElements(elements);
//
//        int[] array = matrixCreator.createFromListToArray(integers2);
//
//        matrixCreator.createFromArrayToMatrix(array);

        /** (4) */
//
//        Phaser phaser = new Phaser();
//        phaser.register();
//
//        new Thread(new ThreadFour(phaser, "phaser 1", elements, changer)).start();
//        new Thread(new ThreadFour(phaser, "phaser 2", elements, changer)).start();
//
//        /** wait for complete phase  0 */
//        int phase = phaser.getPhase();
//        phaser.arriveAndAwaitAdvance();
//        System.out.println("Фаза " + phase + " завершена");
//
//        /** wait for complete phase 1 */
//        phase = phaser.getPhase();
//        phaser.arriveAndAwaitAdvance();
//        System.out.println("Фаза " + phase + " завершена");
//
//
//
//        /** complete all phases and delete objects */
//        phaser.arriveAndDeregister();
//
//        List<Integer> integers2;
//        integers2 = matrixCreator.createListIntegerFromElements(elements);
//
//        int[] array = matrixCreator.createFromListToArray(integers2);
//
//        matrixCreator.createFromArrayToMatrix(array);

    }

}
