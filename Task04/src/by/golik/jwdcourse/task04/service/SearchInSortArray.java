package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class is a collection of methods for searching elements in an array.
 */
public class SearchInSortArray {
    Array array;

    /**
     *
     * @param array
     */
    public SearchInSortArray(Array array) {
        this.array = array;
    }

    /**
     *
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
    public int binarySearch(Array sortArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortArray.getElement(mid) < key) {
                low = mid + 1;
            } else if (sortArray.getElement(mid) > key) {
                high = mid - 1;
            } else if (sortArray.getElement(mid) == key) {
                index = mid + 1;
                break;
            }
        }
        return index;
    }

    /**
     *
     * @param sortArray
     * @return
     */
    public int binarySearchInSortArray(SortArray sortArray) {
        int first = 0;
        int a = number(array);
        int last = sortArray.array.getLength()-1;
        return binarySearch(sortArray.array, a, first, last);
    }

    /**
     *
     * @param array
     * @return
     */
    //TODO
    public Array primeNumbersBruteForce(Array array) {
        for (int i = 0; i < array.getLength(); i++){
            if (primeNumber(array.getElement(i)) == 1){
                System.out.print(array.getElement(i) + " ");
            }
        }
        System.out.println(" - Array of prime numbers");
        return array;
    }

    /**
     *
     * @param number
     * @return
     */
    private static int primeNumber(int number) {
        for (int i=2; i<number; i++)
        {
            if (number%i == 0)
            {
                return 0;
            }

            if ((i == number) || (i>Math.sqrt(number)))
            {
                return 1;
            }
        }
        return 0;
    }

    /**
     *This method finds fibonacci numbers in the array.
     *
     * Sequence in which the first two numbers are either 1 and 1, or 0 and 1,
     * and each subsequent number is equal to the sum of the two previous numbers.
     * @return
     * @param sortArray
     */

    public Array fibonacciSearch(SortArray sortArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во чисел фибоначчи, которе хотите получить");
        int count = scanner.nextInt();

        array.setElement(0, 0);
        array.setElement(1, 1);
        for (int i = 2; i < count; ++i) {
            array.setElement(i, array.getElement(i - 1) + array.getElement(i - 2));
        }
        for (int i = 0; i < count; ++i) {
            System.out.println(array.getElement(i));
        }
        return array;
    }

    /**
     * This method finds all three-digit numbers in decimal notation that do not have the same digits.
     *
     * @param array - array in which must be found this numbers.
     * @return
     */
    public Array findNumbersWithThreeDifferentDigits(Array array) {
        String number;

        List<Array> result = new ArrayList<>();
        for (int i = 0; i < array.getLength(); i++) {
            number = array.toString();
            if (number.length() == 3 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(0) != number.charAt(2)) {
                result.add(array);
            }
        }
        return array;
    }
}
