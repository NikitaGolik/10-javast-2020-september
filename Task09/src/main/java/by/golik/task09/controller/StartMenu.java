package by.golik.task09.controller;

import by.golik.task09.service.exceptions.IncorrectInputParametersException;

/**
 * @author Nikita Golik
 */
public class StartMenu {

    public static void main( String[] args ) throws IncorrectInputParametersException {
        new MainController().startMainMenu();
    }

}
