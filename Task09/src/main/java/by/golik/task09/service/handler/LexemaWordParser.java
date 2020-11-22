package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this class describes parsing text by words and lexemas
 * @author Nikita Golik
 */
public class LexemaWordParser implements TextParser {

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

        TextComposite lexeme;
        TextComposite word;
        String lexemeString;
        String wordString;
        /** to find all lexemas */
        Pattern patternLexeme = Pattern.compile(REGEX_LEXEMA);
        Matcher matcherLexeme = patternLexeme.matcher(sentenceString);
        /** to find all words */
        Pattern patternWord = Pattern.compile(REGEX_WORD);
        Matcher matcherWord;
        /** to find all lexemas with expressions */
        Pattern patternLexemeWithExpression = Pattern.compile(REGEX_LEXEMA_WITH_EXPRESSION);
        Matcher matcherLexemeWithExpression;

        while (matcherLexeme.find()) {

            /** create new lexema, when it's found */
            lexeme = new TextComposite(TextElementType.LEXEMA);
            lexemeString = matcherLexeme.group();

            matcherWord = patternWord.matcher(lexemeString);
            if(matcherWord.find()) {
                
                wordString = matcherWord.group();
                matcherLexemeWithExpression = patternLexemeWithExpression.matcher(wordString);
                if(!matcherLexemeWithExpression.find()) {
                    word = new TextComposite(TextElementType.WORD);
                    symbolParser.parse(word, wordString);
                    sentence.add(word);
                }
            }

            matcherLexemeWithExpression = patternLexemeWithExpression.matcher(lexemeString);
            if (matcherLexemeWithExpression.find()) {
                String expressionString = matcherLexemeWithExpression.group();
                symbolParser.parse(lexeme, expressionString);
            }
            else {
                symbolParser.parse(lexeme, lexemeString);
            }
            sentence.add(lexeme);
        }
    }
}
