package by.golik.jwdcourse.task04.controller;

import by.golik.jwdcourse.task04.beans.Array;
import by.golik.jwdcourse.task04.controller.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CreateArrays {
Controller controller;
    /**
     *
     * This method fills the array with the numbers entered from the console.
     *
     * @return
     */
    public static int[] fillFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length");
        int size = scanner.nextInt();
        int[] arrayConsole = new int[size];
        System.out.println("Insert array elements");
        for (int i = 0; i < size; i++) {
            arrayConsole[i] = scanner.nextInt();
        }
        return arrayConsole;
    }

    /**
     *
     * This method fills the array with the numbers entered from .txt file.
     * @throws FileNotFoundException - Constructs a FileNotFoundException with null as its error detail message.
     * @return
     */
    public static int[] fillFromFile() throws FileNotFoundException {
        File file = new File("D:\\demo\\testArray.txt");
        Scanner scanner = new Scanner(file);
        int[] arrayFile = new int[5];
        for (int i = 0; scanner.hasNextInt(); i++) {
            arrayFile[i] = scanner.nextInt();
        }
        return arrayFile;
    }

    /**
     * This method fills the array with random numbers.
     *
     * @return
     */
    public static int[] fillByRandom() {
        int [] arrayRandom = new int[10];
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = ((int) (Math.random() * 31) - 15);
        }
        return arrayRandom;
    }

}
