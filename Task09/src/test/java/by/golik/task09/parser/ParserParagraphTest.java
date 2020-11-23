package by.golik.task09.parser;

import by.golik.task09.service.exception.*;
import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.handler.WholeTextParser;
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

        String fileName = ".\\resources\\data\\text.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);
            Assert.assertEquals(textComposite.size(), expectedSize);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Problem with reading file!");
        }
    }
}
