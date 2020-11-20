package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Nikita Golik
 */
public class ParserSentence extends AbstractParser {
    private static final Logger logger = LogManager.getLogger(ParserSentence.class);

    public static final String REGEX_SENTENCE = "(?sx-m)[^\\r\\n].*?(?:(?:\\.|\\?|!))";

    public ParserSentence(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.SENTENCE;
        super.regEx = REGEX_SENTENCE;
    }
}
