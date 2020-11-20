package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.TextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public class ParserLexema extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);

    private static final String REGEX_LEXEMA = "(\\W+)?(\\w+)?(\\W+)?";

    public ParserLexema(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.LEXEMA;
        super.regEx = REGEX_LEXEMA;
    }
}
