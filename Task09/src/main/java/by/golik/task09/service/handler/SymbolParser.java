package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import by.golik.task09.bean.Symbol;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class SymbolParser implements TextParser {

    /** regex to find all symbols in text */
    private static final String REGEX_SYMBOL = "(\\w)|([^\\w\\s])";

    /**
     * method to parse text by symbols
     * @param lexemeOrWord - element of text (lexema or word)
     * @param lexemeOrWordString - String value of word or lexema
     * @throws IncorrectInputParametersException - when failed to read text
     */
    @Override
    public void parse(TextComposite lexemeOrWord, String lexemeOrWordString) throws IncorrectInputParametersException {

        Symbol symbol;
        String partString;
        Pattern patternPart = Pattern.compile(REGEX_SYMBOL);
        Matcher matcherSymbol = patternPart.matcher(lexemeOrWordString);

        for(int i=0; i<lexemeOrWordString.length(); i++) {
            if (matcherSymbol.find()) {
                partString = matcherSymbol.group();
                symbol = new Symbol(partString, TextElementType.SYMBOL);
                lexemeOrWord.add(symbol);
            }
        }
    }
}
