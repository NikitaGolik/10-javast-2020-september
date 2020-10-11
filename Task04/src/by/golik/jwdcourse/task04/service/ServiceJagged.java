package by.golik.jwdcourse.task04.service;

import java.util.Scanner;

/**
 *
 */
public class ServiceJagged {
    private int row;
    private int col;
    private int[][] jaggedArray;

    public ServiceJagged(int[][] jaggedArray) {
        this.jaggedArray = jaggedArray;
    }

    public ServiceJagged(int row, int col) {
        this.row = row;
        this.col = col;
        jaggedArray = new int[row][col];
    }

    public void matrixSquare(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of Rows Matrix: ");
        countRows = scanner.nextInt();
        System.out.println("Enter count of Columns Matrix: ");
        countCol = scanner.nextInt();
        if (countRows == countCol) {
            System.out.println("Матрица является квадратной");
        }
    }

    public int[][] additionJagged(int[][] m, int[][] n) {

    }

    public int[][] subtractionJagged(int[][] m, int[][] n) {

    }

    public void multiplyOnConstantJagged(int[][]m, int n) {


    }

        /**
         * Matrix multiplication method.
         * @param m Multiplicand
         * @param n Multiplier
         * @return Product
         */
    public int[][] multiplyByMatrix(int[][]m, int[][] n) {
        int m1ColLength = m[0].length; // m columns length
        int m2RowLength = n.length;    // n rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m.length;    // m result rows length
        int mRColLength = n[0].length; // m result columns length
        int[][] mResult = new int[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m
            for(int j = 0; j < mRColLength; j++) {     // columns from n
                for(int k = 0; k < m1ColLength; k++) { // columns from m
                    mResult[i][j] += m[i][k] * n[k][j];
                }
            }
        }
        return mResult;
    }
    public void transpose() {
        int n = 3;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = n*i + j;
            }
        }
        // часть 2 - выводит на экран начальную матрицу
        System.out.println("Начальная матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        // часть 3 - транспонирование матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // часть 4 - выводит на экран транспонированную матрицу
        System.out.println();
        System.out.println("Новая матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
    }
    
}
