package by.golik.jwdcourse.task04.controller;

/**
 * @author Nikita
 */


import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainController {

    public static class Main {
        public static void main(String[] args) throws FileNotFoundException {
            // write your code here

          new Controller(new Scanner(System.in)).start();

        }
    }
}
