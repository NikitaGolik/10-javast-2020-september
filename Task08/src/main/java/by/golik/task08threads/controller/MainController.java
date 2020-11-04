package by.golik.task08threads.controller;

import by.golik.task08threads.service.MatrixCreator;

/**
 * @author Nikita Golik
 */
public class MainController {
    public static void main(String[] args) throws Exception {

        MatrixCreator matrixCreator = new MatrixCreator();
        matrixCreator.fillFromFile();
    }
}
