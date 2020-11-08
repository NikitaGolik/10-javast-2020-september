package by.golik.task08threads.service;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MatrixCreator;
import com.sun.tools.javac.Main;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class ThreadOneCall implements Callable<Matrix> {
    public static final int NUMBER_ONE = 111;

    MatrixCreator matrixCreator = new MatrixCreator();
    Semaphore sem;
    String name;
    Matrix matrix = new Matrix();

    public ThreadOneCall(MatrixCreator matrixCreator, Semaphore sem, String name) {
        this.matrixCreator = matrixCreator;
        this.sem = sem;
        this.name = name;
    }

    public ThreadOneCall(Matrix matrix, String name) {
        this.name = name;
        this.matrix = matrix;
    }

    public Matrix call() throws Exception {

        try {
            System.out.println(name + " ожидает разрешение");

            matrix = matrixCreator.fillFromFile();

            for(int i = 0; i < matrix.getDiagonalSize()/2; i++) {
                for(int j = 0; j < matrix.getHorizontalSize()/2; j++) {
                    if(i == j) {
                        matrix.setElement(i, j, NUMBER_ONE);
                    }
                }
            }
            for(int i = matrix.getDiagonalSize()/2; i < matrix.getDiagonalSize(); i++) {
                for (int j = matrix.getHorizontalSize() / 2; j < matrix.getHorizontalSize(); j++) {
                    if (i == j) {
                        matrix.setElement(i, j, ThreadTwo.NUMBER_TWO);
                    }
                }
            }
                Thread.sleep(100);
        } catch (InterruptedException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println(name + " освобождает разрешение");
        System.out.println(matrix);
        return matrix;
    }
}
