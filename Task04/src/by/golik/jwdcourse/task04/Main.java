package by.golik.jwdcourse.task04;
import by.golik.jwdcourse.task04.beans.Array;
import by.golik.jwdcourse.task04.controller.Controller;
import by.golik.jwdcourse.task04.view.Command;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Nikita
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Controller controller = new Controller();
        new Command(new Scanner(System.in)).start();














    }
}
