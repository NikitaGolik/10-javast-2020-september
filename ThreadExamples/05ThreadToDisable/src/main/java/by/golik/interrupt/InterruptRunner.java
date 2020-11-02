package by.golik.interrupt;

/**
 * @author Nikita Golik
 */
public class InterruptRunner {
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        InterruptThread t = new InterruptThread("InterruptThread");
        t.start();
        try{
            Thread.sleep(150);
            t.interrupt();

            Thread.sleep(150);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
