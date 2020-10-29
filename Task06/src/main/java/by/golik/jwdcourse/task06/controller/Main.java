package by.golik.jwdcourse.task06.controller;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import java.io.IOException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException, BookAlreadyHaveException, BookNotExistException {
        Controller controller = new Controller(new Scanner(System.in));
        controller.start();

    }
}
