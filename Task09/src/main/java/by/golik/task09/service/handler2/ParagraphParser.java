package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class ParagraphParser implements TextParser {
    private static final String REGEX_PARAGRAPH = "\\t.+\\n*[^\\t]+";

    private SentenceParser sentenceParser = new SentenceParser();

    @Override
    public void parse(CompositeTextElement wholeText, String text) throws IncorrectInputParametersException {

        CompositeTextElement paragraph;
        String paragraphString;
        Pattern patternParagraph = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = patternParagraph.matcher(text);
        while (matcher.find()) {
            paragraphString = matcher.group();
            paragraph = new CompositeTextElement(ComponentType.PARAGRAPH);
            sentenceParser.parse(paragraph, paragraphString);
            wholeText.add(paragraph);
        }
    }
}
