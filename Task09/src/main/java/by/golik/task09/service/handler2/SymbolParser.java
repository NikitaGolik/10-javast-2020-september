package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.Symbol;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class SymbolParser implements TextParser {

    private static final String REGEX_LEAF = "(\\w)|([^\\w\\s])";

    @Override
    public void parse(CompositeTextElement lexemeOrWord, String lexemeOrWordString) throws IncorrectInputParametersException {

        Symbol symbol;
        String leafString;
        Pattern patternLeaf = Pattern.compile(REGEX_LEAF);
        Matcher matcherSymbol = patternLeaf.matcher(lexemeOrWordString);

        for(int i=0; i<lexemeOrWordString.length(); i++) {
            if (matcherSymbol.find()) {
                leafString = matcherSymbol.group();
//                symbol = new Symbol(leafString, ComponentType.SYMBOL);
//                lexemeOrWord.add(symbol);
            }
        }
    }
}
