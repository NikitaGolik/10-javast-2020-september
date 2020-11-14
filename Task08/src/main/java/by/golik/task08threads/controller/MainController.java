package by.golik.task08threads.controller;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.service.CollectionTransformer;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.service.threads.ThreadOne;
import by.golik.task08threads.service.threads.ThreadOneCall;
import by.golik.task08threads.service.threads.ThreadTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nikita Golik
 */
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    public static void main(String[] args) throws Exception {

        logger.info("sas");
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

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        for(Element element : elements) {
            System.out.println(element.toString());
        }

        /** (2) */


        ArrayList<Future<Matrix>> list = new ArrayList<Future<Matrix>>();

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 5; i++) {

        }
        es.shutdown();
        for (Future<Matrix> future : list) {
            System.out.println(future.get() + " result fixed");
        }

        es.shutdown();

        /** (3) */
//        Semaphore matrixSemaphore = new Semaphore(2);
//
//        new Thread(new ThreadFourSemaphore(matrixSemaphore, "thread1"));
//        new Thread(new ThreadFourSemaphore(matrixSemaphore, "thread2"));


    }

}
