package by.golik.task08threads.controller;

import by.golik.task08threads.beans.*;
import by.golik.task08threads.service.ThreadOne;
import by.golik.task08threads.service.ThreadThree;
import by.golik.task08threads.service.ThreadTwo;

/**
 * @author Nikita Golik
 */
public class MainController {
    public static void main(String[] args) throws Exception {

//        MatrixCreator matrixCreator = new MatrixCreator();
//
//        ArrayList<Future<Matrix>> list = new ArrayList<Future<Matrix>>();
//
//        ExecutorService es = Executors.newFixedThreadPool(3);
//
//        for (int i = 1; i < 5; i++) {
//            list.add(es.submit(new ThreadTwo(matrixCreator.fillFromFile(), "thread1")));
//        }
//        es.shutdown();
//        for (Future<Matrix> future : list) {
//            System.out.println(future.get() + " result fixed");
//        }
//
//
//        es.shutdown();

       /** (2) */

        ThreadThree myThread = new ThreadThree(ThreadTwo.NUMBER_TWO, 2, MatrixSingleton.getInstance());
        ThreadThree myThread1 = new ThreadThree(ThreadOne.NUMBER_ONE, 2, MatrixSingleton.getInstance());
        myThread.start();
        myThread1.start();
        myThread.join();
        myThread1.join();


    }

}
