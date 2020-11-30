package by.golik.entity;

import by.golik.service.SymbolParser;
import by.golik.service.TextParser;

/**
 * @author Nikita Golik
 */
public class Main {
    static int ARRAY_LENGTH = 30;
    static int[] array = new int[ARRAY_LENGTH];

    public static void printArray() {
        for (int i=0; i<ARRAY_LENGTH-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[ARRAY_LENGTH-1]);
    }

    public static void main(String[] args) {



        String path = ".\\resources\\data\\text.txt";
        TextParser textParser = new TextParser();
        SymbolParser symbolParser = new SymbolParser();
        CompositePart wholeText = textParser.parse(path);


    }
}
