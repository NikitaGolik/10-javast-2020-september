package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.Paragraph;
import by.golik.task09.entity.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class ParserSentence extends AbstractParser {

    public static final String REGEX_SENTENCE = "(?sx-m)[^\\r\\n].*?(?:(?:\\.|\\?|!))";

    public ParserSentence(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.SENTENCE;
        super.regEx = REGEX_SENTENCE;
    }
}
