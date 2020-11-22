package by.golik.task.service;

import by.golik.task.bean.TextComposite;
import by.golik.task.bean.TextElementType;
import by.golik.task.exception.IncorrectInputParametersException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {

    private static final String REGEX_SENTENCE = "([A-Z\\d]{1}[^.!?]*\\.{3})|([A-Z\\d]{1}[^.!?]*[.!?.]{1})";

    private LexemaWordParser lexemaWordParser = new LexemaWordParser();

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
        }
    }
}
