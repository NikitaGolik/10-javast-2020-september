package by.golik;

import java.util.concurrent.TimeUnit;

/**
 * @author Nikita Golik
 */
public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    public void run() {
        String nameThread = getName();
        long timeout = 0;
        System.out.println("Start of thread " + nameThread);
        try {
            switch (nameThread) {
                case "First":
                    timeout = 5;
                    break;
                case "Second":
                    timeout = 1;
            }
            TimeUnit.MILLISECONDS.sleep(timeout);
            System.out.println("Ending of thread " + nameThread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
