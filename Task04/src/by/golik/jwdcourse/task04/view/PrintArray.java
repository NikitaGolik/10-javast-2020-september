package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.service.SortArray;
import java.util.Arrays;

public class PrintArray {
    SortArray sortArray;
    /**
     * This method prints elements of array
     * @param text - information about array
     * @param array - elements of array
     */
    public static void printArray(String text, int[] array) {
       System.out.println(text + Arrays.toString(array) + "\n");
    }

    /**
     * This method prints Sorted elements of array
     * @param text - information about array
     * @param array - elements of array
     */
    public static void printSortedArray(String text, int[] array) {
        System.out.println(text + " "+ Arrays.toString(array) + "\n");
    }
}
