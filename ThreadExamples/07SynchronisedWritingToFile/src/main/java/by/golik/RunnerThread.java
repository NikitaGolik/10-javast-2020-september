package by.golik;

import java.io.IOException;

/**
 * @author Nikita Golik
 */
public class RunnerThread {
    public static void main(String[] args) {
        WriterThread wt = null;
        try {
            wt = new WriterThread (".\\resources\\data\\result.txt");
            SynchronisedThread t1 = new SynchronisedThread("First", wt);
            SynchronisedThread t2 = new SynchronisedThread("Second", wt);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        } finally {
            wt.close();
        }
    }
}
