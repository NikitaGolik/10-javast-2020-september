package by.golik;

/**
 * @author Nikita Golik
 */
public class JoinRunner {
    static {
        System.out.println("Start of thread main");
    }

    public static void main(String[] args) {
        JoinThread t1 = new JoinThread("First");
        JoinThread t2 = new JoinThread("Second");
        t1.start();
        t2.start();
        try {
            t1.join(); // thread main is stopped until ending of work of thread t1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()); // name of current thread
    }
}
