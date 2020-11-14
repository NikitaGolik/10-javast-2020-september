package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class MatrixCreator {
    /**
     * Create matrix from file
     *
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
            matrix = new Matrix(size, size);
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

    public List<Integer> createListIntegerFromElements(List<Element> elements) {
        List<Integer> integers = new ArrayList<>();

        for(int i = 0; i < elements.size(); i++) {
                integers.add(elements.get(i).getValue());
            } return integers;
        }

    public int[] createFromListToArray(List<Integer> integerList) throws Exception {
        int[] word = new int[integerList.size()];

        for(int i = 0; i < integerList.size(); i++) {
            word[i] = integerList.get(i);
            System.out.println(word[i]);
        }
        return word;
    }
    public Matrix createFromArrayToMatrix(int[] array) throws Exception {
        int raw = 10, col = 10; //ширина и высота двумерного массива
        int count = 0;
        //массив - донор
        int[][] matrix = new int[raw][col]; //будущая матрица
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = array[count++]; //перенос элементов из донора в матрицу
            }
        }
        Matrix matrix1 = new Matrix(10,10);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix1.put(i, j, matrix[i][j]);
            }
        }
        System.out.println(matrix1);
        return matrix1;
    }
}
