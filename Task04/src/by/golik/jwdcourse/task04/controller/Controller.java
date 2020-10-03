package by.golik.jwdcourse.task04.controller;
import by.golik.jwdcourse.task04.view.ConsoleReader;
import by.golik.jwdcourse.task04.view.FileReader;
import by.golik.jwdcourse.task04.view.RandomArray;
import by.golik.jwdcourse.task04.view.impl.Reader;

import java.io.FileNotFoundException;

public class Controller {

    public int[] getConsoleReader() {
        Reader consoleReader = new ConsoleReader();
        return consoleReader.fillFromConsole();
    }
    public int[] getFromFIle() throws FileNotFoundException {
        Reader fileReader = new FileReader();
        return fileReader.fillFromFile();
    }
    public int[] getRandomArray() {
        Reader randomArray = new RandomArray();
        return randomArray.fillByRandom();
    }


}
