package by.golik.task09.sort;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElement;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.handler.WholeTextParser;
import by.golik.task09.service.sort.SortParagraphes;
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
public class SortParagraphesTest {

    @Test
    public void sortParagraphsByNumberOfSentencesTest() {

        List<String> expectedResult = Arrays.asList(" Привет.", " Привет. Привет.", " Привет. Привет. Привет");

        String fileName = ".\\resources\\data\\paragraph.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);
            List<TextElement> sortedParagraphList = new SortParagraphes().sort(textComposite);
            List<String> result = new ArrayList<>();
            for (int i=0; i<sortedParagraphList.size(); i++) {
                result.add(sortedParagraphList.get(i).toString());
            }
            Assert.assertEquals(result, expectedResult);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
