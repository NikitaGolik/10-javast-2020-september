package by.golik;

import java.util.concurrent.TimeUnit;

/**
 * @author Nikita Golik
 */
public class ThreadRunner {

    public static int counter = 0;
    static StringBuffer s = new StringBuffer();
    //можно заменить на стрингбилдер, тогда вывод будет другим

    public static void main(String[] args) throws InterruptedException {

        new Thread() {
            public void run() {
                synchronized (s) {
                    while (ThreadRunner.counter++ < 3) {
                        s.append("A");
                        System.out.print("> " + counter + " ");
                        System.out.println(s);
                        try {
                            TimeUnit.MILLISECONDS.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        TimeUnit.MILLISECONDS.sleep(100);
        while (ThreadRunner.counter++ < 6) {
            System.out.print("< " + counter + " ");
        // в этом месте поток main будет ждать освобождения блокировки объекта s
            s.append("B");
            System.out.println(s);
        }
    }
}
