package by.golik.task08threads.controller;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.ThreadOne;
import by.golik.task08threads.beans.ThreadTwo;
import by.golik.task08threads.service.MatrixCreator;
import by.golik.task08threads.service.MatrixModificator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Nikita Golik
 */
public class MainController {
    public static void main(String[] args) throws Exception {

        Semaphore sem = new Semaphore(1);
        MatrixCreator matrixCreator = new MatrixCreator();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Matrix>> list = new ArrayList<Future<Matrix>>();

        Callable<Matrix> callable = new ThreadOne(matrixCreator, sem, "thread 1");

            Future<Matrix> future = executorService.submit(callable);
            list.add(future);

        executorService.shutdown();
        for(Future<Matrix> fut : list) {
            System.out.println(fut.get() + "fixed");
        }



    }
}
