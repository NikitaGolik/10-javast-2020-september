package by.golik.jwdcourse.task04.controller;
import by.golik.jwdcourse.task04.service.SearchInArray;
import by.golik.jwdcourse.task04.service.ServiceJagged;
import by.golik.jwdcourse.task04.service.SortArray;
import by.golik.jwdcourse.task04.view.Command;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static by.golik.jwdcourse.task04.view.PrintArray.*;


public class Controller {
    Command command = new Command();
    private Scanner scanner;

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
                        printArray(array);
                        sort(array);
                        break;
                    case "2" :
                        array = CreateArrays.fillFromFile();
                        printArray(array);
                        sort(array);
                        break;
                    case "3" :
                        array = CreateArrays.fillByRandom();
                        printArray(array);
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
                        printSearchNumbers("Index of your number is", arrayForUser.search());
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
                        printArray(searchFibonacciInArray.fibonacciSearch(insertionSortArray3));
                        break;
                    case "9" :
                        SearchInArray searchDigitsInArray = new SearchInArray(array);
                        searchDigitsInArray.findNumbersWithThreeDifferentDigits(array);
                        printArray(searchDigitsInArray.findNumbersWithThreeDifferentDigits(array));
                        break;
                    case "10" :
                        SearchInArray searchPrimeInArray = new SearchInArray(array);
                        printArray(searchPrimeInArray.primeNumbersBruteForce(array));
                        break;
                    case "11" :
                        addJagged();
                    case "12" :
                        System.out.println("");
                        break;
                    default :
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while (!key.equals("12"));
        }
    }
    public void addJagged() throws FileNotFoundException {
        int[][] jaggedArray = new int[0][0];
        if (this.scanner != null) {
            String key;
            boolean continueInput = true;
            do {
                command.printMenuForJaggedArrays();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        jaggedArray = CreateJaggedArrays.fillJaggedFromConsole();
                        printJaggedArray(jaggedArray);
                        actionsJagged(jaggedArray);
                    case "2" :
                        jaggedArray = CreateJaggedArrays.fillJaggerFromFile();
                        printJaggedArray(jaggedArray);
                        actionsJagged(jaggedArray);
                    case "3" :
                        jaggedArray = CreateJaggedArrays.fillJaggedByRandom();
                        printJaggedArray(jaggedArray);
                        actionsJagged(jaggedArray);
                    case "4" :
                        System.out.println("Завершение программы");
                        break;
                    default :
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while(!key.equals("4"));
        }
    }
    public void actionsJagged(int[][] jaggedArray) {
        if (this.scanner != null) {
            String key;
            boolean continueInput = true;
            do {
                command.printMenuForActionsWithJaggedArrays();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1":
                        ServiceJagged matrixSquare = new ServiceJagged(jaggedArray);
                        matrixSquare.matrixSquare(jaggedArray);
                        break;
                    case "2":
                        ServiceJagged additionJagged = new ServiceJagged(jaggedArray);
                        additionJagged.additionJagged(jaggedArray, CreateJaggedArrays.fillJaggedByRandom());
                        break;
                    case "3":
                        ServiceJagged subtractionJagged = new ServiceJagged(jaggedArray);
                        subtractionJagged.subtractionJagged(jaggedArray, CreateJaggedArrays.fillJaggedByRandom());
                        break;
                    case "4":
                        ServiceJagged multiplyOnConstant = new ServiceJagged(jaggedArray);
                        multiplyOnConstant.multiplyOnConstantJagged(jaggedArray, 5);
                        break;
                    case "5":
                        ServiceJagged transposeJagged = new ServiceJagged(jaggedArray);
                        transposeJagged.transpose();
                        break;
                    case "6":
                        ServiceJagged sortJagged = new ServiceJagged(jaggedArray);
                        sortJagged.sortJaggedArray(jaggedArray);
                    case "7":
                        System.out.println("Завершение программы");
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while (!key.equals("7"));
        }
    }
}

