package by.golik.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @author Nikita Golik
 */
public class DaemonThread extends Thread {
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("старт потока-демона");
                TimeUnit.SECONDS.sleep(10);
        } else {
                System.out.println("старт обычного потока");
            }
    } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!isDaemon()) {
                System.out.println("завершение обычного потока");
            } else {
                System.out.println("завершение потока-демона");
            }
        }
    }
}
