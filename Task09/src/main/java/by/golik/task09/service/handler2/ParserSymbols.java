package by.golik.task09.service.handler2;

import by.golik.task09.entity.Symbol;
import by.golik.task09.entity.TextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Nikita Golik
 */
public class ParserSymbols extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserSymbols.class);

    @Override
    public TextElement parse(String text) {
        return new Symbol(text.charAt(0));
    }
}
