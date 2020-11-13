package by.golik.task08threads.service;
import by.golik.task08threads.beans.Matrix;
import java.io.*;
import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class MatrixCreator {
    /**
     * Create matrix from file
     * @return getting matrix
     */

    public Matrix fillFromFile() {

        int size = 10;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(".\\resources\\data\\Matrix.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Matrix matrix = null;
        try {
            matrix = new Matrix(size,size);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assert scanner != null;
                assert matrix != null;
                matrix.put(i, j, scanner.nextInt());
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            System.out.print(matrix.get(i, j) + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}
