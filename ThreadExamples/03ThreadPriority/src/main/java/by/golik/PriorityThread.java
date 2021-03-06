package by.golik;

/**
 * @author Nikita Golik
 */
public class PriorityThread extends Thread {

    public PriorityThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}
