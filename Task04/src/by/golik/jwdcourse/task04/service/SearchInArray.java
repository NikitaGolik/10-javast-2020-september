package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.service.impl.SearchArray;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is a collection of methods for searching elements in an array.
 */
public class SearchInArray implements SearchArray {
    int [] array;

    /**
     *
     * @param array - constructor that creates na object.
     */
    public SearchInArray(int[] array) {
        this.array = array;
    }

    /**
     * This method searches the element of the array using binary search.
     *
     * the middle element of the sorted array and compare it with the desired one.
     * If the element is less, we will continue the search in the left part of the array,
     * if it is more in the right, until the required element remains.
     *
     * @param sortArray - sorted array, in which must be found element of array.
     * @param key - desired value.
     * @return index of desired value in array.
     */
    public int binarySearch(int[] sortArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortArray[mid] < key) {
                low = mid + 1;
            } else if (sortArray[mid] > key) {
                high = mid - 1;
            } else if (sortArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int binarySearchInSortArray(SortArray sortArray) {
        int first = 0;
        int last = sortArray.array.length-1;
        return binarySearch(sortArray.array, 5, first, last);
    }

    /**
     *
     * @param
     * @return
     */

    //TODO
    public int[] primeNumbersBruteForce(int[] n) {
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n.length; i++) {
            if (isPrimeBruteForce(i)) {
                primeNumbers.add(i);
            }
        } int[] arr = primeNumbers.stream().mapToInt(i -> i).toArray();
        return arr;
    }
    public boolean isPrimeBruteForce(int number) {
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *This method finds fibonacci numbers in the array.
     *
     * Sequence in which the first two numbers are either 1 and 1, or 0 and 1,
     * and each subsequent number is equal to the sum of the two previous numbers.
     */
    //todo
    public int[] fibonacciSearch(SortArray sortArray) {
        int n0 = 1;
        int n1 = 1;
        int n2;
        for(int i = 3; i < sortArray.array.length; i++){
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return sortArray.array;
    }

    /**
     * This method finds all three-digit numbers in decimal notation that do not have the same digits.
     *
     * @param array - array in which must be found this numbers.
     * @return
     */
    public int[] findNumbersWithThreeDifferentDigits(int[] array) {
        String number;

        List<Integer> result = new ArrayList<Integer>();
        for (Integer sourceNumber : array) {
            number = sourceNumber.toString();
            if (number.length() == 3 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(0) != number.charAt(2)) {
                result.add(sourceNumber);
            }
        }
        int[] arr = result.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
