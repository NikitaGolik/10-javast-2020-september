package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this class describes parsing text by words and lexemas
 * @author Nikita Golik
 */
public class LexemaWordParser implements TextParser {

    private static final Logger logger = LogManager.getLogger();

    /** regex to find all words, lexemas, and lexemas with expressions */
    private static final String REGEX_LEXEMA = "([^\\s]+)";
    private static final String REGEX_WORD = "([a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+)|([a-zA-Z]+-[a-zA-Z]+)|([^(),:'\\.!?*\\/\\-\\d\\s]+)|(([^\\s]*\\d+[+\\-*\\/]+[^\\s]*))";
    private static final String REGEX_LEXEMA_WITH_EXPRESSION = "([^\\s]*\\d+[+\\-*\\/]+[^\\s]*)";

    private SymbolParser symbolParser = new SymbolParser();

    /**
     * this methods parses sentences on lexemas and words
     * @param sentence - element of text - sentence
     * @param sentenceString - strinf value of element of text - sentence
     * @throws IncorrectInputParametersException - when failed to read text
     */
    @Override
    public void parse(TextComposite sentence, String sentenceString) throws IncorrectInputParametersException {

        TextComposite lexema;
        TextComposite word;
        String lexemaString;
        String wordString;

        /** to find all lexemas */
        Pattern patternLexema = Pattern.compile(REGEX_LEXEMA);
        Matcher matcherLexema = patternLexema.matcher(sentenceString);

        /** to find all words */
        Pattern patternWord = Pattern.compile(REGEX_WORD);
        Matcher matcherWord;

        /** to find all lexemas with expressions */
        Pattern patternLexemeWithExpression = Pattern.compile(REGEX_LEXEMA_WITH_EXPRESSION);
        Matcher matcherLexemaWithExpression;

        /**
         * at first wi find lexemas in sentences, then we define words, after that lexemas with expressions
         */
        while (matcherLexema.find()) {

            /** create new lexema, when it's found */
            lexema = new TextComposite(TextElementType.LEXEMA);
            lexemaString = matcherLexema.group();

            matcherWord = patternWord.matcher(lexemaString);
            if(matcherWord.find()) {

                wordString = matcherWord.group();
                matcherLexemaWithExpression = patternLexemeWithExpression.matcher(wordString);
                if(!matcherLexemaWithExpression.find()) {
                    word = new TextComposite(TextElementType.WORD);
                    symbolParser.parse(word, wordString);
                    sentence.add(word);

                    logger.info(word + "has been added to parser" + getClass().getSimpleName());
                }
            }

            matcherLexemaWithExpression = patternLexemeWithExpression.matcher(lexemaString);
            if (matcherLexemaWithExpression.find()) {
                String expressionString = matcherLexemaWithExpression.group();
                symbolParser.parse(lexema, expressionString);
            }
            else {
                symbolParser.parse(lexema, lexemaString);
            }
            sentence.add(lexema);

            logger.info(lexema + "has been added to parser" + getClass().getSimpleName());
        }
    }
}
