package by.golik.task08threads.service.threads;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MatrixCreator;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
//public class ThreadFourSemaphore implements Runnable {
//    public static final int NUMBER_FOUR = 444;
//
//
//    Semaphore matrixSemaphore;
//    String name;
//
//    public ThreadFourSemaphore(Semaphore matrixSemaphore, String name) {
//        this.matrixSemaphore = matrixSemaphore;
//        this.name = name;
//    }

//    @Override
//    public void run() {
//        MatrixCreator matrixCreator = new MatrixCreator();
//        Matrix matrix = new Matrix();
//        try {
//            matrix = matrixCreator.fillFromFile();
//        } catch (Exception e) {
//            Logger.getLogger(ThreadFourSemaphore.class.getName()).log(Level.SEVERE, null, e);
//        }
//            try {
//                matrixSemaphore.acquire();
//                int diagonalSize = matrix.getDiagonalSize();
//                for(int i = 0; i < diagonalSize/2; i++) {
//                    matrix.setDiagonalElement(NUMBER_FOUR);
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(100);
//                    } catch (InterruptedException e) {
//                        Logger.getLogger(ThreadFourSemaphore.class.getName()).log(Level.SEVERE, null, e);
//                    }
//                }
//                for (int j = diagonalSize/2; j < diagonalSize; j++) {
//                    matrix.setDiagonalElement(ThreadTwo.NUMBER_TWO);
//                }
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                Logger.getLogger(ThreadFourSemaphore.class.getName()).log(Level.SEVERE, null, e);
//            }
//        matrixSemaphore.release();
//        System.out.println(matrix);
//    }
//}
