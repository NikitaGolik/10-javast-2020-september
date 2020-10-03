package by.golik.jwdcourse.task04.service.impl;

import java.util.List;

public interface SearchArray {
    int binarySearch(int [] sortedArray, int key, int low, int high);
    int[] fibonacciSearch();
    List<Integer> findNumbersWithThreeDifferentDigits(int[] array);
}
