package by.golik.task10web.controller;

import by.golik.task10web.exception.IncorrectInputException;
import by.golik.task10web.exception.ParserException;

import java.util.Scanner;


/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws ParserException, IncorrectInputException {

        new ConsoleRunner(new Scanner(System.in)).start();

    }
}
