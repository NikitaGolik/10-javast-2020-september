package by.golik.task09.service.handler;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Nikita Golik
 */
public class ParserSentence extends AbstractParser {
    private static final Logger logger = LogManager.getLogger(ParserSentence.class);

    private static final String REGEX_SENTENCE = "([A-Z\\d]{1}[^.!?]*\\.{3})|([A-Z\\d]{1}[^.!?]*[.!?.]{1})";

    public ParserSentence(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.SENTENCE;
        super.regEx = REGEX_SENTENCE;
    }
}
