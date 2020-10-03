package by.golik.jwdcourse.task04;
import by.golik.jwdcourse.task04.controller.Controller;
import java.io.FileNotFoundException;

/**
 * @author Nikita
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Controller controller = new Controller();
        controller.getRandomArray();
        controller.getConsoleReader();
        controller.getFromFIle();






    }
}
