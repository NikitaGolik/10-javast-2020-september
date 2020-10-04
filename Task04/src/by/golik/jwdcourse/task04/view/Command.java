package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.controller.Controller;
import by.golik.jwdcourse.task04.controller.CreateArrays;
import by.golik.jwdcourse.task04.service.SortArray;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static by.golik.jwdcourse.task04.view.PrintArray.printArray;
import static by.golik.jwdcourse.task04.view.PrintArray.printSortedArray;

public class Command {
    private final Scanner scanner;
    Controller controller = new Controller();


    public Command(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() throws FileNotFoundException {

            System.out.println("Выбери способ заполения массива:");
            System.out.println("1 - ввод с консоли");
            System.out.println("2 - заполнение из файла");
            System.out.println("3 - заполнение случайными числами");
            System.out.println("4 - для выхода");
    }
    public void printSortMenu() {
        System.out.println("Выбери способ сортировки массива:");
        System.out.println("1 - пузырек");
        System.out.println("2 - выбором");
        System.out.println("3 - вставкой");
        System.out.println("4 - для выхода");
    }

    public void start() throws FileNotFoundException {
        if (this.scanner != null) {
            String key;
            do {
                printMenu();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        int[] arrayFromConsole = CreateArrays.fillFromConsole();
                        printArray("Array from console \n", arrayFromConsole);
                        sort();
                        break;
                    case "2" :
                        int[] arrayFromFile = CreateArrays.fillFromFile();
                        printArray("Array from file \n", arrayFromFile);
                        sort();
                        break;
                    case "3" :
                        int [] arrayFromRandom = CreateArrays.fillByRandom();
                        printArray("Array from Random \n", arrayFromRandom);
                        sort();
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
    public void sort() throws FileNotFoundException {
        if (this.scanner != null) {
            String key;
            do {
                printSortMenu();
                System.out.println("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        SortArray bubbleSortArray = new SortArray(CreateArrays.fillFromConsole());
                        bubbleSortArray.bubbleSort();
                        printSortedArray("Sorted Array \n", bubbleSortArray);
                        break;
                    case "2" :
                        SortArray selectionSortArray = new SortArray(CreateArrays.fillFromFile());
                        selectionSortArray.selectionSort();
                        printSortedArray("Sorted Array", selectionSortArray);
                        break;
                    case "3" :
                        SortArray insertionSortArray = new SortArray(CreateArrays.fillFromFile());
                        insertionSortArray.insertionSort();
                        printSortedArray("Sorted Array", insertionSortArray);
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
}
