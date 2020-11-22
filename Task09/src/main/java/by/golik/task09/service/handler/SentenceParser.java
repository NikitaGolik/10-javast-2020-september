package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class-parser text by sentences
 * @author Nikita Golik
 */
public class SentenceParser implements TextParser {

    private static final Logger logger = LogManager.getLogger();

    private static final String REGEX_SENTENCE = "([A-Z\\d]{1}[^.!?]*\\.{3})|([A-Z\\d]{1}[^.!?]*[.!?.]{1})";

    private LexemaWordParser lexemaWordParser = new LexemaWordParser();

    /**
     *
     * @param paragraph - element of text, that should be parsed
     * @param paragraphString - string value of sentence element
     * @throws IncorrectInputParametersException - if failed while reading file
     */
    @Override
    public void parse(TextComposite paragraph, String paragraphString) throws IncorrectInputParametersException {

        TextComposite sentence;
        String sentenceString;

        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = patternSentence.matcher(paragraphString);

        while (matcher.find()) {
            sentenceString = matcher.group();
            sentence = new TextComposite(TextElementType.SENTENCE);
            lexemaWordParser.parse(sentence, sentenceString);
            paragraph.add(sentence);

            logger.info(sentence + "has been added to parser" + getClass().getSimpleName());
        }
    }
}
