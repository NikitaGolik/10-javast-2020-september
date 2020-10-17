package by.golik.jwdcourse.task04.controller;
import by.golik.jwdcourse.task04.beans.Array;
import by.golik.jwdcourse.task04.beans.JaggedArray;
import by.golik.jwdcourse.task04.service.*;
import by.golik.jwdcourse.task04.view.Command;
import java.util.Scanner;
import static by.golik.jwdcourse.task04.view.PrintArray.*;


public class Controller {
    Command command = new Command();
    private Scanner scanner;
    ArraysCreator arraysCreator = new ArraysCreator();
    JaggedArraysCreator jaggedArraysCreator = new JaggedArraysCreator();

    /**
     *
     * @param scanner
     */
    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     *
     * @throws Exception
     */
    public void start() throws Exception {
        Array array = null;
        if (this.scanner != null) {
            String key;
            do {
                command.printMenu();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        array = arraysCreator.fillFromConsole(array, scanner);
                        printArray(array);
                        sort(array);
                        break;
                    case "2" :
                        array = arraysCreator.fillFromFile(array);
                        printArray(array);
                        sort(array);
                        break;
                    case "3" :
                        array = arraysCreator.fillByRandom(array, 10, 100);
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

    /**
     *
     * @param array
     * @throws Exception
     */
    public void sort(Array array) throws Exception {
        if (this.scanner != null) {
            String key;
            boolean continueInput = true;
            do {
                command.printSortMenu();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        SortArray bubbleSortArray = new SortArray(array);
                        bubbleSortArray.bubbleSort(array);
                        printSortedArray(bubbleSortArray.array);
                        break;
                    case "2" :
                        SortArray selectionSortArray = new SortArray(array);
                        selectionSortArray.selectionSort(array);
                        printSortedArray(selectionSortArray.array);
                        break;
                    case "3" :
                        SortArray insertionSortArray = new SortArray(array);
                        insertionSortArray.insertionSort(array);
                        printSortedArray(insertionSortArray.array);
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
                        SearchInSortArray searchBinaryInArray = new SearchInSortArray(array);
                        SortArray insertionSortArray2 = new SortArray(array);
                        insertionSortArray2.insertionSort(array);
                        printSearchNumbers("Your number has index ", searchBinaryInArray.binarySearchInSortArray(insertionSortArray2));
                        break;
                    case "8" :
                        SearchInSortArray searchFibonacciInArray = new SearchInSortArray(array);
                        SortArray insertionSortArray3 = new SortArray(array);
                        insertionSortArray3.insertionSort(array);
                        printArray(searchFibonacciInArray.fibonacciSearch(insertionSortArray3));
                        break;
                    case "9" :
                        SearchInSortArray searchDigitsInArray = new SearchInSortArray(array);
                        searchDigitsInArray.findNumbersWithThreeDifferentDigits(array);
                        printArray(searchDigitsInArray.findNumbersWithThreeDifferentDigits(array));
                        break;
                    case "10" :
                        SearchInSortArray searchPrimeInArray = new SearchInSortArray(array);
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

    /**
     *
     * @throws Exception
     */
    public void addJagged() throws Exception {

        if (this.scanner != null) {
            String key;
            boolean continueInput = true;
            do {
                command.printMenuForJaggedArrays();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        jaggedArraysCreator.fillJaggedFromConsole();
                        actionsJagged();
                    case "2" :
                        jaggedArraysCreator.fillJaggerFromFile();
                        actionsJagged();
                    case "3" :
                        JaggedArray jaggedArray = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray,2,10);
                        actionsJagged();
                    case "4" :
                        System.out.println("Завершение программы");
                        break;
                    default :
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while(!key.equals("4"));
        }
    }

    /**
     *
     * @throws Exception
     */
    public void actionsJagged() throws Exception {
        if (this.scanner != null) {
            String key;
            boolean continueInput = true;
            do {
                command.printMenuForActionsWithJaggedArrays();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1":
                        JaggedArray jaggedArray = new JaggedArray(5,2);
                        ServiceJagged matrixSquare = new ServiceJagged();
                        matrixSquare.matrixSquare(jaggedArray);
                        break;
                    case "2":
                        JaggedArray jaggedArray1 = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray1, 2, 8);
                        System.out.println("first " + jaggedArray1);

                        JaggedArray jaggedArray2 = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray2, 2, 7);
                        System.out.println("Second " + jaggedArray2);

                        ServiceJagged serviceJagged = new ServiceJagged();
                        System.out.println("result " + serviceJagged.additionJagged(jaggedArray1, jaggedArray2));

                        break;
                    case "3":
                        jaggedArray1 = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray1, 2, 8);
                        System.out.println("first " + jaggedArray1);

                        jaggedArray2 = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray2, 2, 7);
                        System.out.println("Second " + jaggedArray2);

                        serviceJagged = new ServiceJagged();
                        System.out.println("result " + serviceJagged.subtractionJagged(jaggedArray1, jaggedArray2));

                        break;
                    case "4":
                        jaggedArray = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray, 2,10);

                        ServiceJagged multiplyOnConstant = new ServiceJagged();
                        System.out.println("result " + multiplyOnConstant.multiplyOnConstantJagged(jaggedArray, 5));
                        break;
                    case "5":
                        jaggedArray = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray, 2,10);

                        ServiceJagged transposeJagged = new ServiceJagged();
                        System.out.println("result " + transposeJagged.transpose(jaggedArray));
                        break;
                    case "6":
                        jaggedArray = new JaggedArray(5,5);
                        jaggedArraysCreator.fillJaggedByRandom(jaggedArray,2,10);

                        ServiceJagged sortedJagged = new ServiceJagged();
                        sortedJagged.SortArrayIncreaseSumOFElementsInRaw(jaggedArray);

                        break;
                    case "7":

                        break;
                    case "8":

                        break;
                    case "9":
                        System.out.println("Завершение программы");
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while (!key.equals("7"));
        }
    }
}

