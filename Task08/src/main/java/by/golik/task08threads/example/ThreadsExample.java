package by.golik.task08threads.example;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MatrixCreator;

import java.util.ArrayList;

/**
 * @author Nikita Golik
 */
public class ThreadsExample {

    public static int pos = 0;
    static int size = 10;
    static ArrayList<Thread> a_t = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Matrix matrix;
        MatrixCreator matrixCreator = new MatrixCreator();
        matrix = matrixCreator.fillFromFile();


        for(int i = 0; i < matrix.getDiagonalSize(); i++) {
            a_t.add(new Thread((Runnable) new Resource()));
        }
        for(Thread thread : a_t) {
            thread.start();
        }
        for(Thread thread : a_t) {
            thread.join();
        }
    }

}
