package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.service.SortArray;
import java.util.Arrays;

public class PrintArray {
    SortArray sortArray;

    /**
     * This method prints elements of array
     *
     * @param text  - information about array
     * @param array - elements of array
     */
    public static void printArray(String text, int[] array) {
        System.out.println(text + Arrays.toString(array) + "\n");
    }

    /**
     * This method prints Sorted elements of array
     *
     * @param text  - information about array
     * @param array - elements of array
     */
    public static void printSortedArray(String text, int[] array) {
        System.out.println(text + " " + Arrays.toString(array) + "\n");
    }

    public static void printSearchNumbers(String text, int number) {
        System.out.println(text + " " + number);
    }

    public static void printJaggedArray(String text, int[][] jaggedArray) {
        System.out.println(text + " " + Arrays.toString(jaggedArray) + "\n");
    }
}