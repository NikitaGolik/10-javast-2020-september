package by.golik;


public class Main {
    public static void main(String[] args) {
        System.out.println("Main is started");

        RunnablePerson p1 = new RunnablePerson("First person");
        Thread t1 = new Thread(p1);
        t1.start();

        RunnablePerson p2 = new RunnablePerson("Second person");
        Thread t2 = new Thread(p2);
        t2.start();

    }
}
