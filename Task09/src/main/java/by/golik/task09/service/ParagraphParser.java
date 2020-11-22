package by.golik.task09.service;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.service.exception.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements TextParser {

    private static final String REGEX_PARAGRAPH = "\\t.+\\n*[^\\t]+";

    private SentenceParser sentenceParser = new SentenceParser();

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
        }
    }
}
