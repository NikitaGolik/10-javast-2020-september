package by.golik.task09.parser;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.service.exceptions.IncorrectInputFileException;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.handler.ParserText;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Nikita Golik
 */
public class ParserParagraphTest {
    @Test
    public void paragraphParserTest() {

        int expectedSize = 4;

        String fileName = "data/text.txt";
        File file = new File(fileName);
//        try {
//            String wholeText = new ReadText().read(file);
//            CompositeTextElement textComposite = new CompositeTextElement(ComponentType.TEXT.TEXT);
//            new ParserText().parse(textComposite, wholeText);
//            Assert.assertEquals(textComposite.size(), expectedSize);
//        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
//            Assert.fail("Unexpected fail!");
//        }
    }
}
