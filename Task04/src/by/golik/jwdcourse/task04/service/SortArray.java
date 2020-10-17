package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * This class is a collection of methods for sorting elements in an array.
 */

public class SortArray {

    public Array array;

    public SortArray(Array array) {
        this.array = array;
    }

    /**
     * Line search using a loop.
     * This method searches the array by the specified value.
     * @param array
     * @return
     */
    public int number(Array array) {
        System.out.println("Введите число, которое надо найти: ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            boolean continueInput = true;
            int x = 0;
            do {
                try {
                    x = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Введите число");
                    scanner.nextLine();
                }
            } while (continueInput);
            return x;
        }
    }

    /**
     *
     * @return
     */
    public int search() {
        int a = number(array);
        int index = -1;
        int length = array.getLength();
        for( int i = 0; i < length; i++) {
            if (a == array.getElement(i)) {
                index = i+1;
                break;
            }
            if (i == length-1) {
                System.out.println("Число " + a + " не найдено в массиве.");
            }
        }
        return index-1;
    }

    /**
     * This method finds the maximum value of an element in the array.
     * @return
     */
    public int maxValue() {
        int max = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (array.getElement(i) > max)
                max = array.getElement(i);
        }
        return max;
    }

    /**
     * This method finds the minimum value of an element in the array.
     * @return
     */
    public int minValue() {
        int min = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (array.getElement(i) < min)
                min = array.getElement(i);
        }
        return min;
    }

    /**
     * This method sorts the array using the bubble sort method.
     * Starting from the beginning we look through 2 elements
     * If the second element in the pair is less than the first element,
     * move it to the place of the first, and the first to the place of the second.
     * After we have reached the end of the array, we check if there was at least one exchange.
     * If yes, then the array is not sorted and we start all over again.
     * We repeat such passes until it turns out that there was not a single exchange.
     * @param array
     * @return
     */
    public Array bubbleSort(Array array) {

        for (int i = array.getLength() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.getElement(j) > array.getElement(j + 1)) {
                    int tmp = array.getElement(j);
                    array.setElement(j, array.getElement(j+1));
                    array.setElement(j + 1, tmp);
                }
            }
        }
        return array;
    }

    /**
    * This method sorts the array using the selection sort method.
    * Fnd the number of the minimum value in the current list
    * we exchange this value with the value of the first unsorted position
    * (the exchange is not needed if the minimum element is already at this position)
    * now we sort the tail of the list, excluding already sorted elements from consideration.
    */
    public Array selectionSort(Array array) {
        for (int i = 0; i < array.getLength(); i++) {    // i - номер текущего шага
            int pos = i;
            int min = array.getElement(i);
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.getLength(); j++) {
                if (array.getElement(j) < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array.getElement(i);
                }
            }
            array.setElement(pos, array.getElement(i));
            array.setElement(i, min);
        }
        return array;
    }

    /**
     * This method sorts the array using the insertion sort method.
     * The elements of the input sequence are scanned one at a time,
     * and each new element arriving is placed in a suitable place among the previously ordered elements
     * @param array
     * @return
     */
    public Array insertionSort(Array array) {
        for (int left = 0; left < array.getLength(); left++) {
            int value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getElement(i)) {
                    array.setElement(i + 1, array.getElement(i));
                } else {
                    break;
                }
            }
            array.setElement( i + 1, value);
        }
        return array;
    }
}
