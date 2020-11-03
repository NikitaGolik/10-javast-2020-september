package by.golik;

/**
 * @author Nikita Golik
 */
public class ThreadRunner {
    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
