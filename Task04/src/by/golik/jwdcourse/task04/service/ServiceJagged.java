package by.golik.jwdcourse.task04.service;

import by.golik.jwdcourse.task04.view.ConsoleReader;

import java.util.Scanner;

/**
 *
 */
public class ServiceJagged {
    private int row;
    private int col;
    private int[][] jaggedArray;
    ConsoleReader consoleReader;

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
        row = scanner.nextInt();
        System.out.println("Enter count of Columns Matrix: ");
        col = scanner.nextInt();
        if (row == col) {
            System.out.println("Матрица является квадратной");
        }
    }

    public int[][] additionJagged(int[][] matrix1, int[][] matrix2) {
        int n;
        int m;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите количество строк: ");
            n = in.nextInt();
            System.out.print("Введите количество столбцов: ");
            m = in.nextInt();
            matrix1 = new int[n][m];
            System.out.println("Введите элеменнты 1 массива, по порядку: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix1[i][j] = in.nextInt();
                }
            }
            matrix2 = new int[n][m];
            System.out.println("Введите элеменнты 2 массива, по порядку: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix2[i][j] = in.nextInt();
                }
            }
        }
        System.out.println("Матрица 1: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Матрица 2: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Сумма матриц: ");
        int[][] finalMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                finalMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(finalMatrix[i][j] + " ");

            }
            System.out.println();
        }
        return finalMatrix;

    }


    public int[][] subtractionJagged(int[][] matrix1, int[][] matrix2) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = in.nextInt();
        System.out.print("Введите количество столбцов: ");
        int m = in.nextInt();
        matrix1 = new  int [n][m];
        System.out.println("Введите элеменнты 1 массива, по порядку: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1 [i][j] = in.nextInt();
            }
        }
        matrix2 = new  int [n][m];
        System.out.println("Введите элеменнты 2 массива, по порядку: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix2 [i][j] = in.nextInt();
            }
        }
        System.out.println("Матрица 1: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Матрица 2: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Разница матриц: ");
        int[][] finalMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                finalMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(finalMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return finalMatrix;
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
