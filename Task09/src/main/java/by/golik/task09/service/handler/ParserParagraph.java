package by.golik.task09.service.handler;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public class ParserParagraph extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);

    private static final String REGEX_PARAGRAPH = "\\t.+\\n*[^\\t]+";

    public ParserParagraph(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.PARAGRAPH;
        super.regEx = REGEX_PARAGRAPH;
    }
}
