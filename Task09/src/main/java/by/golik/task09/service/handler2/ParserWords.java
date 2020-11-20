package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;


/**
 * @author Nikita Golik
 */
public class ParserWords extends AbstractParser {

    public static final String REGEX_WORD = "([A-я]+)";
    public static final String REGEX_WORD_OR_PUNCTUATION = "([A-я]+)|(.)";

    public ParserWords(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.WORDORPUNCTUATION;
        super.regEx = REGEX_WORD_OR_PUNCTUATION;
    }
}
