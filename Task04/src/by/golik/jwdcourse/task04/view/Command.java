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

}
