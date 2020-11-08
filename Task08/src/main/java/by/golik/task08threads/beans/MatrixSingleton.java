package by.golik.task08threads.beans;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nikita Golik
 */
public class MatrixSingleton {
    private static MatrixSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();
    private Matrix matrix;

    private MatrixSingleton() {
    }

    public static MatrixSingleton getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new MatrixSingleton();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

}
