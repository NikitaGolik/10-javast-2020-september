package by.golik.jwdcourse.task04.view.impl;

import java.io.FileNotFoundException;

public interface Reader {
    public int[] fillFromConsole();
    public int[] fillFromFile() throws FileNotFoundException;
    public int[] fillByRandom();

}
