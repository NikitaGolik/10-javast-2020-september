package by.golik.task09.service.handler;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public class ParserLexema extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);

    private static final String REGEX_LEXEMA_WITH_EXPRESSION = "([^\\s]*\\d+[+\\-*\\/]+[^\\s]*)";

    public ParserLexema(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.LEXEMA;
        super.regEx = REGEX_LEXEMA_WITH_EXPRESSION;
    }
}
