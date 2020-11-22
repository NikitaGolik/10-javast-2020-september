package by.golik.task09.service;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import by.golik.task09.bean.Symbol;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser implements TextParser {

    private static final String REGEX_LEAF = "(\\w)|([^\\w\\s])";

    @Override
    public void parse(TextComposite lexemeOrWord, String lexemeOrWordString) throws IncorrectInputParametersException {

        Symbol symbol;
        String leafString;
        Pattern patternLeaf = Pattern.compile(REGEX_LEAF);
        Matcher matcherSymbol = patternLeaf.matcher(lexemeOrWordString);

        for(int i=0; i<lexemeOrWordString.length(); i++) {
            if (matcherSymbol.find()) {
                leafString = matcherSymbol.group();
                symbol = new Symbol(leafString, TextElementType.SYMBOL);
                lexemeOrWord.add(symbol);
            }
        }
    }
}
