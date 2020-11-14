package by.golik.task08threads.controller;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.MatrixAsList;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.service.CollectionTransformer;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.service.threads.ThreadOne;
import by.golik.task08threads.service.threads.ThreadOneCall;
import by.golik.task08threads.service.threads.ThreadThree;
import by.golik.task08threads.service.threads.ThreadTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

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

//        ThreadOne threadOne = new ThreadOne(elements, changer);
//        ThreadTwo threadTwo = new ThreadTwo(elements, changer);
//
//        threadOne.start();
//        threadTwo.start();
//
//        threadOne.join();
//        threadTwo.join();
//
//        for(Element element : elements) {
//            System.out.println(element.toString());
//        }

//        /** (2) */
//
//        ExecutorService es = Executors.newFixedThreadPool(3);
//        es.execute(new ThreadOne(elements,changer));
//        es.execute(new ThreadTwo(elements,changer));
//
//        es.shutdown();


        /** (3) */
        MatrixAsList matrixAsList = new MatrixAsList(elements);

        Semaphore matrixSemaphore = new Semaphore(2);

        new Thread(new ThreadThree(matrixSemaphore, "thread1",matrixAsList, ThreadThree.NUMBER_FOUR)).start();
        new Thread(new ThreadThree(matrixSemaphore, "thread2", matrixAsList, ThreadOne.NUMBER_TWO)).start();

    }

}
