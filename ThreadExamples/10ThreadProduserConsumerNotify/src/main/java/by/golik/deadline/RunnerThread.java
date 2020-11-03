package by.golik.deadline;

/**
 * @author Nikita Golik
 */
public class RunnerThread {

    public static void main(String[] args) {
        Store store = new Store();
        (new Thread(new Producer(store))).start();
        (new Thread(String.valueOf(new Consumer(store)))).start();
    }

}
