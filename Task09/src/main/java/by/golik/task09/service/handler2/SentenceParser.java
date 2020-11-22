package by.golik.task09.service.handler2;



import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {

    private static final String REGEX_SENTENCE = "([A-Z\\d]{1}[^.!?]*\\.{3})|([A-Z\\d]{1}[^.!?]*[.!?.]{1})";

    private LexemeOrWordParser lexemeOrWordParser = new LexemeOrWordParser();

    @Override
    public void parse(CompositeTextElement paragraph, String paragraphString) {

        CompositeTextElement sentence;
        String sentenceString;
        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = patternSentence.matcher(paragraphString);
        while (matcher.find()) {
            sentenceString = matcher.group();
            sentence = new CompositeTextElement(ComponentType.SENTENCE);
            lexemeOrWordParser.parse(sentence, sentenceString);
            paragraph.add(sentence);
        }
    }
}
