package by.golik.task08threads.service.threads;
import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MyThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nikita Golik
 */
public class ThreadTwo {
    public static final int NUMBER_TWO = 222;

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
