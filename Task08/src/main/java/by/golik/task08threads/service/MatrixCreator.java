package by.golik.task08threads.service;
import by.golik.task08threads.bean.Matrix;
import java.io.File;
import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class MatrixCreator {

    public Matrix fillFromFile() throws Exception {

        File file = new File(".\\resources\\data\\Matrix.txt");
        Scanner scanner = new Scanner(file);
        Matrix matrix = new Matrix(scanner.nextInt());
        for (int i = 0; i < matrix.getLength(); i++) {
            try {
                int value = scanner.nextInt();
                matrix.setElement(i, value);
            } catch (Exception e) {
                e.printStackTrace();
            }


            for (int j = 0; j < matrix.getLength(); j++) {
                System.out.println(matrix.getElement(j));
            }
        } return matrix;
    }
}
