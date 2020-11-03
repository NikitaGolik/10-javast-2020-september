package by.golik;

import java.util.concurrent.Semaphore;

/**
 * @author Nikita Golik
 */
public class ThreadRunner {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1); // 1 разрешение
        CommonResource res = new CommonResource();
        new Thread(new CountThread(res, sem, "CountThread 1")).start();
        new Thread(new CountThread(res, sem, "CountThread 2")).start();
        new Thread(new CountThread(res, sem, "CountThread 3")).start();
    }
}

