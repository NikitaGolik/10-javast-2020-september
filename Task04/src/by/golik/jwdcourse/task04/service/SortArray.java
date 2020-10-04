package by.golik.jwdcourse.task04.service;

import by.golik.jwdcourse.task04.service.impl.ArrayService;

/**
 *
 * This class is a collection of methods for sorting elements in an array.
 */

public class SortArray implements ArrayService {
    public int [] array;

    public SortArray(int[] array) {
        this.array = array;
    }



    /** Line search using a loop.
     * This method searches the array by the specified value.
     * @return
     */
    public int search() {
        int x = 0;
        int index = -1;
        for( int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                index = i;
                break;
            }
        }
        return array[index];
    }

    /**
     * This method finds the maximum value of an element in the array.
     */
    public int maxValue() {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    /**
     * This method finds the minimum value of an element in the array.
     */
    public int minValue() {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
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
     *
     */
    public int[] bubbleSort() {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
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
     *
     */
    public int[] selectionSort() {
        for (int min = 0; min < array.length; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            int tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
        }
        return array;

    }

    /**
     * This method sorts the array using the insertion sort method.
     *
     * The elements of the input sequence are scanned one at a time,
     * and each new element arriving is placed in a suitable place among the previously ordered elements
     */
    public int[] insertionSort() {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        return array;
    }
}
