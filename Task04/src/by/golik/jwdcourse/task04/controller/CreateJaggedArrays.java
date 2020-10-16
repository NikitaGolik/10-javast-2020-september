package by.golik.jwdcourse.task04.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateJaggedArrays {
    public static int[][] fillJaggedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of raws");
        int raw = scanner.nextInt();
        System.out.println("Enter count of cols");
        int col = scanner.nextInt();
        int[][] matrix = new int[raw][col];
        System.out.println("Insert Array elements");
        for (int i = 0; i < raw  ; i++) {
            for (int j = 0; j < col ; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] fillJaggerFromFile() throws FileNotFoundException {
        int[][] arrayFile = null;
        File file = new File("D:\\eclipse-workspace\\10-javast-2020-september\\Task04\\testJaggedArray.txt");

        try {
            Scanner sizeScanner = new Scanner(file);
            String[] temp = sizeScanner.nextLine().split(" ");
            sizeScanner.close();
            int nMatrix = temp.length;

            Scanner scanner = new Scanner(file);
            arrayFile = new int[nMatrix][nMatrix];
            for (int i = 0; i < nMatrix; i++) {
                String[] numbers = scanner.nextLine().split(" ");
                for (int j = 0; j < nMatrix; j++) {
                    arrayFile[i][j] = Integer.parseInt(numbers[j]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arrayFile;
    }

    public static int[][] fillJaggedByRandom() {
        int[][] jaggedRandom = new int[5][5];
        for (int i = 0; i < jaggedRandom.length; i++) {
            for (int j = 0; j < jaggedRandom[i].length; j++) {
                jaggedRandom[i][j] = ((int) (Math.random() * 50) + 25);
            }
        }
        return jaggedRandom;
    }

}
