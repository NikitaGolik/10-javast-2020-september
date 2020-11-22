package by.golik.task09.controller;

import by.golik.task09.bean.CompositeLevel;
import by.golik.task09.bean.TextComposite;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;
import by.golik.task09.service.Action;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.handler.*;
import by.golik.task09.service.handler2.WholeTextParser;
import by.golik.task09.service.put.InputController;
import by.golik.task09.service.put.ReaderFile;
import by.golik.task09.service.query.SortParagraphes;

/**
 * @author Nikita Golik
 */
public class StartMenu {

    private static InputController input = new InputController();

    public static void main( String[] args ) throws IncorrectInputParametersException {
        String fromFileName = ".\\resources\\data\\paragraph.txt";
        String fromFileName2 = ".\\resources\\data\\paragraph.txt";
        String toFileName1 = ".\\resources\\data\\formatted.txt";

        String text1 = new ReaderFile().readFromFile(fromFileName2);

        /** (1) */


        ParserSymbols symbolParser = new ParserSymbols();
        ParserWords wordExpressionParser = new ParserWords(symbolParser);
        ParserLexema lexemaParser = new ParserLexema(wordExpressionParser);
        ParserSentence sentenceParser = new ParserSentence(lexemaParser);
        ParserParagraph paragraphParser = new ParserParagraph(sentenceParser);
        ParserText textParser = new ParserText(paragraphParser);

        TextElement textElement1 = textParser.parse(text1);

        Action action = new Action();

        TextElement textElement2 = action.parseText(text1);

        SortParagraphes sortParagraphes = new SortParagraphes();
        sortParagraphes.sort((CompositeTextElement) textElement2);

        /** (2) */

        TextComposite textComposite = new TextComposite(CompositeLevel.TEXT);
        new WholeTextParser().parse(textComposite, text1);
        String newText = textComposite.toString();

    }

}
