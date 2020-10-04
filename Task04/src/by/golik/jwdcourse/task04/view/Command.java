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
    Command command;


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
        int[] array = new int[0];
        if (this.scanner != null) {
            String key;
            do {
                printMenu();
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
                printSortMenu();
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
}
