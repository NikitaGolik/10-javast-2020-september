package by.golik.jwdcourse.task04.view;

import by.golik.jwdcourse.task04.beans.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */

public class Reader {
    /**
     *
     * This method fills the array with the numbers entered from the console.
     *
     */
    public void fillFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length");
        int size = scanner.nextInt();
        int[] arrayConsole = new int[size];
        System.out.println("Insert array elements");
        for (int i = 0; i < size; i++) {
            arrayConsole[i] = scanner.nextInt();
        }
        System.out.println("Array elements : ");
        for(int i =0; i < size; i++) {
            System.out.println("" + arrayConsole[i]);
        }
    }

    /**
     *
     * This method fills the array with the numbers entered from .txt file.
     * @throws FileNotFoundException - Constructs a FileNotFoundException with null as its error detail message.
     */
    public void fillFromFile() throws FileNotFoundException {
        File file = new File("D:\\demo\\testArray.txt");
        Scanner scanner = new Scanner(file);
        int[] arrayFile = new int[10];
        for (int i = 0; scanner.hasNextInt(); i++) {
            arrayFile[i] = scanner.nextInt();
            System.out.println(arrayFile[i]);
        }
    }

    /**
     * This method fills the array with random numbers.
     *
     */
    public void fillByRandom() {
        int [] arrayRandom = new int[10];
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = ((int) (Math.random() * 31) - 15);
            System.out.println(arrayRandom[i]);
        }
    }

}
