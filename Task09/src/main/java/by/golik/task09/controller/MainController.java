package by.golik.task09.controller;

import by.golik.task09.entity.TextElement;
import by.golik.task09.service.Action;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.handler.*;
import by.golik.task09.service.put.InputController;
import by.golik.task09.service.put.ReaderFile;


/**
 * @author Nikita Golik
 */
public class MainController {

    String fromFileName = ".\\resources\\data\\paragraph.txt";
    String fromFileName2 = ".\\resources\\data\\text.txt";
    String toFileName1 = ".\\resources\\data\\formatted.txt";

    private static InputController input = new InputController();
    String text = new ReaderFile().readFromFile(fromFileName2);



    Action action = new Action();




    public void startMainMenu() throws IncorrectInputParametersException {


    }


}
