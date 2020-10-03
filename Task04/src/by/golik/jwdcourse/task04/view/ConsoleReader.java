package by.golik.jwdcourse.task04.view;

import by.golik.jwdcourse.task04.view.impl.Reader;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */

public class ConsoleReader implements Reader {
    /**
     *
     * This method fills the array with the numbers entered from the console.
     *
     * @return
     */
    public int[] fillFromConsole() {
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
        return arrayConsole;
    }

    @Override
    public int[] getReader() throws FileNotFoundException {
        return fillFromConsole();
    }
}
