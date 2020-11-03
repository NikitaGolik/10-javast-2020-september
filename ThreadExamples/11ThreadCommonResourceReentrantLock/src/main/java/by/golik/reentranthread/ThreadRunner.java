package by.golik.reentranthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nikita Golik
 */
public class ThreadRunner {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        for (int i = 1; i < 6; i++) {

            Thread t = new Thread(new ThreadCount(commonResource, locker));
            t.setName("Поток " + i);
            t.start();
        }
    }
}
