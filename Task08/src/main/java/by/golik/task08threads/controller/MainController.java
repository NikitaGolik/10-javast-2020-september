package by.golik.task08threads.controller;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.MatrixSingleton;
import by.golik.task08threads.beans.ThreadThree;
import by.golik.task08threads.beans.ThreadTwo;
import by.golik.task08threads.example.MyThread;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.example.Resource;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        myThread.start();
        myThread.join();


    }

}
