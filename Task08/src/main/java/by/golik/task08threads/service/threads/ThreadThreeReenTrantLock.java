package by.golik.task08threads.service.threads;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.beans.MatrixSingleton;
import by.golik.task08threads.service.MatrixCreator;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class ThreadThreeReenTrantLock extends  Thread {

    private int number;
    private int threadCount;
    private MatrixSingleton singleton;
    private ReentrantLock reentrantLock = new ReentrantLock();



    public ThreadThreeReenTrantLock(int number, int threadCount, MatrixSingleton singleton) {
        this.number = number;
        this.threadCount = threadCount;
        this.singleton = singleton;

    }

    @Override
    public void run() {
        MatrixCreator matrixCreator = new MatrixCreator();
        Matrix matrix = new Matrix();
        try {
            matrix = matrixCreator.fillFromFile();
        } catch (Exception e) {
            Logger.getLogger(ThreadFourSemaphore.class.getName()).log(Level.SEVERE, null, e);
        }

        reentrantLock.lock();

            int diagonalSize = matrix.getDiagonalSize();
            for(int i = 0; i < diagonalSize/threadCount; i++) {
                matrix.setDiagonalElement(number);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadFourSemaphore.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            reentrantLock.unlock();
        System.out.println(matrix);
    }
}
