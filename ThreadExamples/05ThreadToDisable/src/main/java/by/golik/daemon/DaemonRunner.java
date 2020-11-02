package by.golik.daemon;

/**
 * @author Nikita Golik
 */
public class DaemonRunner {
    public static void main(String[] args) {
        DaemonThread usualThread = new DaemonThread();
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        usualThread.start();
        System.out.println("main");
    }
}
