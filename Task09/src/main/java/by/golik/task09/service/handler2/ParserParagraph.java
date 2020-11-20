package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public class ParserParagraph extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);

    public static final String REGEX_PARAGRAPH_WITH_LISTING = "(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)";

    public ParserParagraph(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.PARAGRAPH;
        super.regEx = REGEX_PARAGRAPH_WITH_LISTING;
    }
}
