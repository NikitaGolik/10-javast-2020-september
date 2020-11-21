package by.golik.task09.service;

import by.golik.task09.entity.TextElement;
import by.golik.task09.service.handler.*;

/**
 * @author Nikita Golik
 */
public class Action {

    public TextElement parseText (String text) {
        ParserSymbols symbolParser = new ParserSymbols();
        ParserWords wordExpressionParser = new ParserWords(symbolParser);
        ParserLexema lexemaParser = new ParserLexema(wordExpressionParser);
        ParserSentence sentenceParser = new ParserSentence(lexemaParser);
        ParserParagraph paragraphParser = new ParserParagraph(sentenceParser);
        ParserText textParser = new ParserText(paragraphParser);
        return textParser.parse(text);
    }
}
