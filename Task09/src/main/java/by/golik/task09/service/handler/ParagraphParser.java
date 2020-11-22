package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class-parser for text by paragraphs
 * @author Nikita Golik
 */
public class ParagraphParser implements TextParser {

    private static final Logger logger = LogManager.getLogger();


    private static final String REGEX_PARAGRAPH = "\\t.+\\n*[^\\t]+";

    private SentenceParser sentenceParser = new SentenceParser();

    /**
     * parse text by paragraphs
     * @param wholeText - text element
     * @param text - String value of input text
     * @throws IncorrectInputParametersException - if failed while reading file
     */
    @Override
    public void parse(TextComposite wholeText, String text) throws IncorrectInputParametersException {

        TextComposite paragraph;
        String paragraphString;

        Pattern patternParagraph = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = patternParagraph.matcher(text);
        while (matcher.find()) {
            paragraphString = matcher.group();
            paragraph = new TextComposite(TextElementType.PARAGRAPH);
            sentenceParser.parse(paragraph, paragraphString);
            wholeText.add(paragraph);

            logger.info(paragraph + "has been added to parser" + getClass().getSimpleName());
        }
    }
}
