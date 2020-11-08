package by.golik.task08threads.controller;
import by.golik.task08threads.beans.MatrixSingleton;
import by.golik.task08threads.service.*;
import java.util.concurrent.Semaphore;

/**
 * @author Nikita Golik
 */
public class MainController {
    public static void main(String[] args) throws Exception {

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
//
//       /** (2) */
//
//        ThreadThreeReenTrantLock myThread = new ThreadThreeReenTrantLock(ThreadTwo.NUMBER_TWO, 2, MatrixSingleton.getInstance());
//        ThreadThreeReenTrantLock myThread1 = new ThreadThreeReenTrantLock(ThreadOneCall.NUMBER_ONE, 2, MatrixSingleton.getInstance());
//        myThread.start();
//        myThread1.start();
//        myThread.join();
//        myThread1.join();

        /** (3) */
        Semaphore matrixSemaphore = new Semaphore(2);

        new Thread(new ThreadFourSemaphore(matrixSemaphore, "thread1"));
        new Thread(new ThreadFourSemaphore(matrixSemaphore, "thread2"));




    }

}
