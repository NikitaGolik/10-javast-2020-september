package by.golik.task08threads.service;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MatrixCreator;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nikita Golik
 */
public class ThreadTwo {
    public static final int NUMBER_TWO = 222;

    Matrix matrix = new Matrix();
    Lock lock = new ReentrantLock();


    public Matrix modify(Matrix matrix) throws Exception {
        lock.lock();

        for(int i = 0; i < matrix.getVerticalSize()/2; i++) {
            for(int j = 0; j < matrix.getHorizontalSize()/2; j++) {
                if(i == j) {
                    matrix.setElement(i, j, ThreadFourSemaphore.NUMBER_FOUR);
                }
            }
        }
        for(int i = matrix.getVerticalSize() / 2; i < matrix.getVerticalSize(); i++) {
            for(int j = matrix.getHorizontalSize() / 2; j < matrix.getHorizontalSize(); j++) {
                if(i == j) {
                    matrix.setElement(i, j, MyThread.NUMBER_FIVE);
                }
            }
        }
        lock.unlock();
        return matrix;

    }


}
