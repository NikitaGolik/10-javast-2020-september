package by.golik;

/**
 * @author Nikita Golik
 */
public class RunnerThread {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();

    }
}
