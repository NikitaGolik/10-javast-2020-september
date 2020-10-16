package by.golik.jwdcourse.task04.view;

import java.util.Scanner;

public class ConsoleReader {
    public int[][] readTwoJagged() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во строк: ");
        int n = scanner.nextInt();
        System.out.print("Введите кол-во столбцов: ");
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("Введите элементы массива, по порядку: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        } return matrix;
    }
}
