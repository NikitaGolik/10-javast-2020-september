package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.service.SortArray;
import java.util.Arrays;

public class PrintArray {

    public static void printArray(String text, int[] array) {
        System.out.println(text + Arrays.toString(array) + "\n");
    }
    public static void printSortedArray(String text, SortArray array) {
        System.out.println(text + " " + array.array[0]  + "\n");
    }
}
