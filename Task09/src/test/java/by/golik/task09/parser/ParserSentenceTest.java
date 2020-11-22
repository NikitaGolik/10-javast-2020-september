package by.golik.task09.parser;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElement;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.handler.WholeTextParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.golik.task09.service.exception.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Nikita Golik
 */
public class ParserSentenceTest {

    @Test
    public void sentenceParserTest() {

        List<String> expectedNumbers = Arrays.asList("2", "2", "1", "1");

        String fileName = ".\\resources\\data\\text.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);

            List<String> numbersOfSentences = new ArrayList<>();
            for(TextElement paragraph: textComposite.getTextComponentList()) {
                if(paragraph.getElementType() == TextElementType.PARAGRAPH) {
                    TextComposite paragraphComposite = (TextComposite) paragraph;
                    int number = 0;
                    for(TextElement sentence: paragraphComposite.getTextComponentList()) {
                        if(sentence.getElementType() == TextElementType.SENTENCE) {
                            number++;
                        }
                    }
                    numbersOfSentences.add(String.valueOf(number));
                }
            }
            Assert.assertEquals(numbersOfSentences, expectedNumbers);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("problem with reading file!");
        }
    }
}
