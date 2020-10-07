package by.golik.jwdcourse.task04.service.impl;

import by.golik.jwdcourse.task04.service.SortArray;

import java.util.List;

public interface SearchArray {
    int binarySearch(int [] sortedArray, int key, int low, int high);
    int[] fibonacciSearch(SortArray sortArray);
    List<Integer> findNumbersWithThreeDifferentDigits(int[] array);
}
