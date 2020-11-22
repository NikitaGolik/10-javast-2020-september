package by.golik.task.parser;

import by.golik.task.bean.TextComposite;
import by.golik.task.bean.TextElementType;
import by.golik.task.exception.IncorrectInputParametersException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemaWordParser implements TextParser {

    private static final String REGEX_LEXEMA = "([^\\s]+)";
    private static final String REGEX_WORD = "([a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+)|([a-zA-Z]+-[a-zA-Z]+)|([^(),:'\\.!?*\\/\\-\\d\\s]+)|(([^\\s]*\\d+[+\\-*\\/]+[^\\s]*))";
    private static final String REGEX_LEXEMA_WITH_EXPRESSION = "([^\\s]*\\d+[+\\-*\\/]+[^\\s]*)";

    private SymbolParser symbolParser = new SymbolParser();

    @Override
    public void parse(TextComposite sentence, String sentenceString) throws IncorrectInputParametersException {

        TextComposite lexeme;
        TextComposite word;
        String lexemeString;
        String wordString;
        Pattern patternLexeme = Pattern.compile(REGEX_LEXEMA);
        Matcher matcherLexeme = patternLexeme.matcher(sentenceString);
        Pattern patternWord = Pattern.compile(REGEX_WORD);
        Matcher matcherWord;
        Pattern patternLexemeWithExpression = Pattern.compile(REGEX_LEXEMA_WITH_EXPRESSION);
        Matcher matcherLexemeWithExpression;

        while (matcherLexeme.find()) {

            lexeme = new TextComposite(TextElementType.LEXEME);
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
