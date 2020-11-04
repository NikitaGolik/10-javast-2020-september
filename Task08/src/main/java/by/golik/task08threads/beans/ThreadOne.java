package by.golik.task08threads.beans;

import by.golik.task08threads.service.MatrixCreator;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

/**
 * @author Nikita Golik
 */
public class ThreadOne implements Callable<Matrix> {
    public static final int NUMBER_ONE = 111;

    MatrixCreator matrixCreator;
    Semaphore sem;
    String name;
    Matrix matrix = new Matrix();

    public ThreadOne(MatrixCreator matrixCreator, Semaphore sem, String name) {
        this.matrixCreator = matrixCreator;
        this.sem = sem;
        this.name = name;
    }
    public Matrix call() {

        try {
            System.out.println(name + " ожидает разрешение");
            sem.acquire();
            matrix = matrixCreator.fillFromFile();

            for(int i = 0; i < matrix.getVerticalSize()/2; i++) {
                for( int j = 0; j < matrix.getHorizontalSize(); j++) {
                    if(i == j) {
                        matrix.setElement(i, j, 5);
                    }
                }
            }
                Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name + " освобождает разрешение");
        sem.release();
        System.out.println(matrix);
        return matrix;
    }

}
