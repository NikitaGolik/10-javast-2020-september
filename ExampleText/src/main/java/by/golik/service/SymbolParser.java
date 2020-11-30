package by.golik.service;

import by.golik.entity.CompositePart;
import by.golik.entity.LeafPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class SymbolParser {

    /**
     * parse to symbol
     * @param wordSignList
     * @param wordSign
     * @return
     */
    public CompositePart parseToSymbol(CompositePart wordSignList,
                                        String wordSign) {
        //
        Pattern pattern = Pattern.compile(TextParser.REGEX_SYMBOL);
        String symbol = "";
        Matcher matcher = pattern.matcher(wordSign);
        LeafPart symbolList;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolList = new LeafPart(symbol);
            System.out.print(symbol);
        }
        return wordSignList;
    }

}
