package by.golik.task09.controller;

import by.golik.task09.entity.TextElement;
import by.golik.task09.service.handler2.*;

import by.golik.task09.service.put.InputController;
import by.golik.task09.service.put.ReaderFile;


/**
 * @author Nikita Golik
 */
public class MainController {

       String fromFileName = ".\\resources\\data\\text2.txt";
       String toFileName1 = ".\\resources\\data\\formatted.txt";

    private static InputController input = new InputController();
    ReaderFile readerFile = new ReaderFile();

    public void startMainMenu() {



        ParserSymbols symbolParser = new ParserSymbols();
        ParserWords wordExpressionParser = new ParserWords(symbolParser);
        ParserSentence sentenceParser = new ParserSentence(wordExpressionParser);

        TextElement text1 = sentenceParser.parse(readerFile.readFromFile(input.getFilePath()));




    }


}
