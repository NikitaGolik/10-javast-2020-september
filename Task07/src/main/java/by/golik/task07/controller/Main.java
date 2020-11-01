package by.golik.task07.controller;
import by.golik.task07.service.exceptions.BookAlreadyHaveException;
import by.golik.task07.service.exceptions.BookNotExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new Scanner(System.in));
        controller.observe();
        controller.start();
    }
}
