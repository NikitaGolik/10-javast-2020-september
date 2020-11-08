package by.golik.task08threads.service;
import by.golik.task08threads.beans.Matrix;
import java.io.File;
import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class MatrixCreator {

    public Matrix fillFromFile() throws Exception {

        File file = new File(".\\resources\\data\\Matrix.txt");
        Scanner scanner = new Scanner(file);
        Matrix matrix = new Matrix(10, 10);
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                try {
                    int value = scanner.nextInt();
                    matrix.setElement(i, j, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return matrix;
    }
}
