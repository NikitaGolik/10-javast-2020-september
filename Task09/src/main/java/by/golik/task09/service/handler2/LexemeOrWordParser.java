package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeOrWordParser implements TextParser {

    private static final String REGEX_LEXEME = "([^\\s]+)";
    private static final String REGEX_WORD = "([a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+)|([a-zA-Z]+-[a-zA-Z]+)|([^(),:'\\.!?*\\/\\-\\d\\s]+)|(([^\\s]*\\d+[+\\-*\\/]+[^\\s]*))";
    private static final String REGEX_LEXEME_WITH_EXPRESSION = "([^\\s]*\\d+[+\\-*\\/]+[^\\s]*)";

    private SymbolParser symbolParser = new SymbolParser();

    @Override
    public void parse(CompositeTextElement sentence, String sentenceString) {

        CompositeTextElement lexeme;
        CompositeTextElement word;
        String lexemeString;
        String wordString;
        Pattern patternLexeme = Pattern.compile(REGEX_LEXEME);
        Matcher matcherLexeme = patternLexeme.matcher(sentenceString);
        Pattern patternWord = Pattern.compile(REGEX_WORD);
        Matcher matcherWord;
        Pattern patternLexemeWithExpression = Pattern.compile(REGEX_LEXEME_WITH_EXPRESSION);
        Matcher matcherLexemeWithExpression;

        while (matcherLexeme.find()) {

            lexeme = new CompositeTextElement(ComponentType.LEXEMA);
            lexemeString = matcherLexeme.group();

            matcherWord = patternWord.matcher(lexemeString);
            if(matcherWord.find()) {
                wordString = matcherWord.group();

                matcherLexemeWithExpression = patternLexemeWithExpression.matcher(wordString);
                if(!matcherLexemeWithExpression.find()) {
                    word = new CompositeTextElement(ComponentType.WORD.WORD);
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
