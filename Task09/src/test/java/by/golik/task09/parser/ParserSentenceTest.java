package by.golik.task09.parser;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;
import by.golik.task09.service.exceptions.IncorrectInputFileException;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.handler.ParserText;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        String fileName = "data/text.txt";

//        try {
//            String wholeText = new ReadText().read(file);
//            CompositeTextElement textComposite = new CompositeTextElement(ComponentType.TEXT.TEXT);
//            new ParserText(textComposite);
//
//            List<String> numbersOfSentences = new ArrayList<>();
//            for(TextElement paragraph: textComposite.getElementList()) {
//                if(paragraph.getComponentType() == ComponentType.PARAGRAPH) {
//                    CompositeTextElement paragraphComposite = (CompositeTextElement) paragraph;
//                    int number = 0;
//                    for(TextElement sentence: paragraphComposite.getElementList()) {
//                        if(sentence.getComponentType() == ComponentType.SENTENCE) {
//                            number++;
//                        }
//                    }
//                    numbersOfSentences.add(String.valueOf(number));
//                }
//            }
//            Assert.assertEquals(numbersOfSentences, expectedNumbers);
//        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
//            Assert.fail("Unexpected fail!");
//        }
    }
}
