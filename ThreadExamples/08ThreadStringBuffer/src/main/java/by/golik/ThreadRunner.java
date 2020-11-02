package by.golik;

import java.util.concurrent.TimeUnit;

/**
 * @author Nikita Golik
 */
public class ThreadRunner {
    public static int counter = 0;
    public static void main(String[] args) {

        final StringBuilder s = new StringBuilder();
        new Thread() {
            public void run() {
                synchronized (s) {
                    do {
                        s.append("A");
                        System.out.println(s);
                        try {
                           TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            System.err.print(e);
                        }
                    } while (ThreadRunner.counter++ < 2);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                synchronized (s) {
                    while (ThreadRunner.counter++ < 6) {
                        s.append("B");
                        System.out.println(s);
                    }
                }
            }
            }.start();
        }
}
