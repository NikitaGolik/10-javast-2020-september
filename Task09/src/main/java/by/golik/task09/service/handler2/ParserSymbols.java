package by.golik.task09.service.handler2;

import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.Symbol;
import by.golik.task09.entity.TextElement;
import by.golik.task09.entity.WordOrPunctuation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class ParserSymbols extends AbstractParser {

    @Override
    public TextElement parse(String text) {
        return new Symbol(text.charAt(0));
    }
}
