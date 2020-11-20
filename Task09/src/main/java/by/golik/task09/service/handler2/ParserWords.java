package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Nikita Golik
 */
public class ParserWords extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserWords.class);
    public static final String REGEX_WORD = "([A-я]+)";
    public static final String REGEX_WORD_OR_PUNCTUATION = "([A-я]+)|(.)";

    public ParserWords(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.WORDORPUNCTUATION;
        super.regEx = REGEX_WORD_OR_PUNCTUATION;
    }
}
