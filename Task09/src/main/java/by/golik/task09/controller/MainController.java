package by.golik.task09.controller;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;
import by.golik.task09.service.Action;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.handler.*;
import by.golik.task09.service.handler2.WholeTextParser;
import by.golik.task09.service.put.InputController;
import by.golik.task09.service.put.ReaderFile;
import by.golik.task09.service.query.SortParagraphes;

import javax.swing.text.html.parser.Parser;


/**
 * @author Nikita Golik
 */
public class MainController {

    String fromFileName = ".\\resources\\data\\paragraph.txt";
    String fromFileName2 = ".\\resources\\data\\text.txt";
    String toFileName1 = ".\\resources\\data\\formatted.txt";

    private static InputController input = new InputController();


    public void startMainMenu()  {

        String text = new ReaderFile().readFromFile(fromFileName);

        ParserSymbols symbolParser = new ParserSymbols();
        ParserWords wordExpressionParser = new ParserWords(symbolParser);
        ParserLexema lexemaParser = new ParserLexema(wordExpressionParser);
        ParserSentence sentenceParser = new ParserSentence(lexemaParser);
        ParserParagraph paragraphParser = new ParserParagraph(sentenceParser);
        ParserText textParser = new ParserText(paragraphParser);
        TextElement text11 = textParser.parse(text);

        Action action = new Action();

        TextElement text22 = action.parseText(text);





    }


}
