package by.golik.task08threads.controller;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.Changer;
import by.golik.task08threads.service.CollectionTransformer;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.service.threads.ThreadOne;
import by.golik.task08threads.service.threads.ThreadTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    public static void main(String[] args) throws Exception {

        /** create matrix */
        MatrixCreator matrixCreator = new MatrixCreator();
        Matrix matrix;
        matrix = matrixCreator.fillFromFile();
        /** integer list */
        List<Integer> integers;
        integers = matrix.convert(matrix);

        CollectionTransformer collectionTransformer = new CollectionTransformer();

        /** integer list */
        List<Element> elements;
        elements = collectionTransformer.transform(matrix.convert(matrix));


        System.out.println(integers);
        for(Element element : elements) {
            System.out.println(element.toString());
        }
        Changer changer = new Changer();

        ThreadOne threadOne = new ThreadOne(elements, changer);
        ThreadTwo threadTwo = new ThreadTwo(elements, changer);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        for(Element element : elements) {
            System.out.println(element.toString());
        }

        /** (1) */

//        MatrixCreator matrixCreator = new MatrixCreator();
//
//        ArrayList<Future<Matrix>> list = new ArrayList<Future<Matrix>>();
//
//        ExecutorService es = Executors.newFixedThreadPool(3);
//
//        for (int i = 1; i < 5; i++) {
//            list.add(es.submit(new ThreadOneCall(matrixCreator.fillFromFile(), "thread1")));
//            list.add(es.submit(new ThreadOneCall(matrixCreator.fillFromFile(), "thread2")));
//        }
//        es.shutdown();
//        for (Future<Matrix> future : list) {
//            System.out.println(future.get() + " result fixed");
//        }
//
//        es.shutdown();

       /** (2) */

//        ThreeThread myThread1 = new ThreeThread(MatrixSingleton.getInstance());
//        ThreeThread myThread2 = new ThreeThread(MatrixSingleton.getInstance());
//        myThread1.start();
//        myThread2.start();
//        myThread1.join();
//        myThread2.join();

        /** (4) */
//        Semaphore matrixSemaphore = new Semaphore(2);
//
//        new Thread(new ThreadFourSemaphore(matrixSemaphore, "thread1"));
//        new Thread(new ThreadFourSemaphore(matrixSemaphore, "thread2"));


    }

}
