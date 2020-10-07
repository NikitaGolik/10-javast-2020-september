package by.golik.jwdcourse.task04.controller;
import by.golik.jwdcourse.task04.service.SearchInArray;
import by.golik.jwdcourse.task04.service.SortArray;
import by.golik.jwdcourse.task04.view.Command;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static by.golik.jwdcourse.task04.view.PrintArray.*;


public class Controller {
    Command command = new Command();
    private Scanner scanner;
    SearchInArray searchInArray;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() throws FileNotFoundException {
        int[] array = new int[0];
        if (this.scanner != null) {
            String key;
            do {
                command.printMenu();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        array = CreateArrays.fillFromConsole();
                        printArray("Array from console \n", array);
                        sort(array);
                        break;
                    case "2" :
                        array = CreateArrays.fillFromFile();
                        printArray("Array from file \n", array);
                        sort(array);
                        break;
                    case "3" :
                        array = CreateArrays.fillByRandom();
                        printArray("Array from Random \n", array);
                        sort(array);
                        break;
                    case "4" :
                        System.out.println("Завершение программы");
                        break;
                    default :
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while (!key.equals("4"));
        }
    }

    public void sort(int[] array) throws FileNotFoundException {
        if (this.scanner != null) {
            String key;
            boolean continueInput = true;
            do {
                command.printSortMenu();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        //TODO ВМЕСТО FILLFROMCONSOLE ПОЛУЧАТЬ МАССИВ ИЗ CONTROLLER
                        SortArray bubbleSortArray = new SortArray(array);
                        bubbleSortArray.bubbleSort();
                        printSortedArray("Sorted Array \n", bubbleSortArray.array);
                        break;
                    case "2" :
                        SortArray selectionSortArray = new SortArray(array);
                        selectionSortArray.selectionSort();
                        printSortedArray("Sorted Array", selectionSortArray.array);
                        break;
                    case "3" :
                        SortArray insertionSortArray = new SortArray(array);
                        insertionSortArray.insertionSort();
                        printSortedArray("Sorted Array", insertionSortArray.array);
                        break;
                    case "4" :
                        SortArray arrayForMin = new SortArray(array);
                        printSearchNumbers("Min value is", arrayForMin.minValue());
                        break;
                    case "5" :
                        SortArray arrayForMax = new SortArray(array);
                        printSearchNumbers("Max value is", arrayForMax.maxValue());
                        break;
                    case "6" :
                        SortArray arrayForUser = new SortArray(array);
                        printSearchNumbers("Your number is", arrayForUser.search());
                        break;
                    case "7" :
                        SearchInArray searchBinaryInArray = new SearchInArray(array);
                        SortArray insertionSortArray2 = new SortArray(array);
                        insertionSortArray2.insertionSort();
                        printSearchNumbers("Your number has index ", searchBinaryInArray.binarySearchInSortArray(insertionSortArray2));
                        break;
                    case "8" :
                        SearchInArray searchFibonacciInArray = new SearchInArray(array);
                        SortArray insertionSortArray3 = new SortArray(array);
                        insertionSortArray3.insertionSort();
                        printArray("Your numbers are ", searchFibonacciInArray.fibonacciSearch(insertionSortArray3));
                        break;
                    case "9" :
                        SearchInArray searchDigitsInArray = new SearchInArray(array);
                        searchDigitsInArray.findNumbersWithThreeDifferentDigits(array);
                        printArray("Your numbers are ", searchDigitsInArray.findNumbersWithThreeDifferentDigits(array));
                        break;
                    case "10" :
                        SearchInArray searchPrimeInArray = new SearchInArray(array);
                        searchPrimeInArray.primeNumbersBruteForce(array);
                        printArray("Your numbers are ", searchPrimeInArray.findNumbersWithThreeDifferentDigits(array));
                    case "11" :
                        System.out.println("");
                        break;
                    default :
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while (!key.equals("10"));
        }
    }
}

