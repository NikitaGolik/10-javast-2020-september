package by.golik;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(String lastName) {
        super(lastName);
    }

    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println("Hello world " + getLastName());
        }
    }
}
