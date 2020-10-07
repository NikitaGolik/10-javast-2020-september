package by.golik.jwdcourse.task04.service.impl;

import by.golik.jwdcourse.task04.service.SortArray;

public interface SearchArray {
    int binarySearch(int [] sortedArray, int key, int low, int high);
    int[] fibonacciSearch(SortArray sortArray);
    int[] findNumbersWithThreeDifferentDigits(int[] array);
}
