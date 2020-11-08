package by.golik.task08threads.beans;

import by.golik.task08threads.service.MatrixCreator;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nikita Golik
 */
public class ThreadThree extends  Thread {

    private int number;
    private int threadCount;
    private MatrixSingleton singleton;
    private ReentrantLock reentrantLock = new ReentrantLock();



    public ThreadThree(int number, int threadCount, MatrixSingleton singleton) {
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
            e.printStackTrace();
        }

        reentrantLock.lock();

            int diagonalSize = matrix.getDiagonalSize();
            for(int i = 0; i < diagonalSize/threadCount; i++) {
                matrix.setDiagonalElement(number);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reentrantLock.unlock();
        System.out.println(matrix);
    }
}
