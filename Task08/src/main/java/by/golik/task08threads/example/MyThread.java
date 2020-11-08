package by.golik.task08threads.example;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MatrixCreator;

/**
 * @author Nikita Golik
 */
public class MyThread extends Thread {
    public static final int NUMBER_FIVE = 555;

    MatrixCreator matrixCreator = new MatrixCreator();
    Matrix matrix = matrixCreator.fillFromFile();
    Resource resource;

    public MyThread() throws Exception {
    }

    @Override
    public void run() {
        try {
            resource.modify(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
