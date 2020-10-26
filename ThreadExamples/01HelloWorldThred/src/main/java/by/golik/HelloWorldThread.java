package by.golik;

/**
 * @author Nikita Golik
 */
public class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello world ! ");
    }

    public static void main(String[] args) {
        HelloWorldThread worldThread = new HelloWorldThread();
        worldThread.run();
    }
}
