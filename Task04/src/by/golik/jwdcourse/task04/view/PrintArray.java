package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.beans.Array;
import by.golik.jwdcourse.task04.beans.JaggedArray;

public class PrintArray {

    /**
     * This method prints elements of array
     *
     * @param -     information about array
     * @param array - elements of array
     */
    public static void printArray(Array array) {
        System.out.println("Your array is : ");
        for (int i = 0; i < array.getLength(); i++) {
            System.out.println(array.getElement(i));
        }
    }

    /**
     * This method prints Sorted elements of array
     *
     * @param -     information about array
     * @param array - elements of array
     */
    public static void printSortedArray(Array array) {
        System.out.println("Your sorted array is : ");
        for (int i = 0; i < array.getLength(); i++) {
            System.out.println(array.getElement(i));
        }
    }

    /**
     * @param text
     * @param number
     */
    public static void printSearchNumbers(String text, int number) {
        System.out.println(text + " " + number);
    }
}
