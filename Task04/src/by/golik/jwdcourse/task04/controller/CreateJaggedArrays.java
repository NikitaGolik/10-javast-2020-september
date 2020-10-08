package by.golik.jwdcourse.task04.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateJaggedArrays {
    public static int[][] fillJaggedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of raws");
        int raw = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix = new int[raw][col];
        System.out.println("Insert Array elements");
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; i++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] fillJaggerFromFile() throws FileNotFoundException {
        File file = new File("D:\\demo\\testArray.txt");
        Scanner scanner = new Scanner(file);
        int[][] arrayFile = new int[5][4];
        for (int i = 0; scanner.hasNextInt(); i++) {
            for (int j = 0; scanner.hasNextInt(); j++) {
                arrayFile[i][j] = scanner.nextInt();
            }
        }
        return arrayFile;
    }

    public static int[][] fillJaggedByRandom() {
        int[][] jaggedRandom = new int[5][5];
        for (int i = 0; i < jaggedRandom.length; i++) {
            for (int j = 0; j < jaggedRandom[i].length; i++) {
                jaggedRandom[i][j] = ((int) (Math.random() * 50) + 25);
            }
        }
        return jaggedRandom;
    }

}
