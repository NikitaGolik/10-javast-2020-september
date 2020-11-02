package by.golik;

/**
 * @author Nikita Golik
 */
public class SynchronisedThread extends Thread {
    private WriterThread wt;
    public SynchronisedThread(String name, WriterThread wt) {
        super(name);
        this.wt = wt;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            wt.writing(getName(), i); // место срабатывания синхронизации
        }
    }
}
