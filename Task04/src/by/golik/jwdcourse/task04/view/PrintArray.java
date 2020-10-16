package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.service.SortArray;
import java.util.Arrays;

public class PrintArray {
    SortArray sortArray;

    /**
     * This method prints elements of array
     *
     * @param  - information about array
     * @param array - elements of array
     */
    public static void printArray(int[] array) {
        System.out.println("Your array is : ");
        for(int o : array) {
            System.out.println(o);
        }
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

    public static void printJaggedArray(int[][] jaggedArray) {
        System.out.println("Your jagged Array");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println();
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j]+" ");
            }
        }
        System.out.println();
    }
}