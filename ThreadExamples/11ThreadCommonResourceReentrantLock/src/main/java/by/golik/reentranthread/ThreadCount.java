package by.golik.reentranthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nikita Golik
 */
public class ThreadCount implements Runnable {
    CommonResource res;
    ReentrantLock locker;

    ThreadCount(CommonResource res, ReentrantLock lock) {
        this.res = res;
        locker = lock;
    }

    public void run() {

        locker.lock(); // устанавливаем блокировку
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }

}
