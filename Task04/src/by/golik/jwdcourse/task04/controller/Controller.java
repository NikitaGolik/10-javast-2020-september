package by.golik.jwdcourse.task04.controller;

import by.golik.jwdcourse.task04.beans.Array;
import by.golik.jwdcourse.task04.service.SortArray;
import by.golik.jwdcourse.task04.view.Command;
import by.golik.jwdcourse.task04.view.PrintArray;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static by.golik.jwdcourse.task04.view.PrintArray.printArray;
import static by.golik.jwdcourse.task04.view.PrintArray.printSortedArray;

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
                        System.out.println("");
                        break;
                    default :
                        System.out.println("Вы ввели неверное значение меню, повторите ввод \n");
                }
            } while (!key.equals("4"));
        }
    }
    public void searchInArray(int[] array) {
        if (this.scanner !=null) {
            String key;
            do{
                command.printMaxAndMinMenu();
                System.out.println("Введите номер меню");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        Array array1 = new Array(array);

                }
            }
        }
    }


}

