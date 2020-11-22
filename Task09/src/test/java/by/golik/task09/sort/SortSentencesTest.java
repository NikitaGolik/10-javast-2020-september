package by.golik.task09.sort;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElement;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.handler.WholeTextParser;
import by.golik.task09.service.sort.SortSentences;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import by.golik.task09.service.exception.*;

/**
 * @author Nikita Golik
 */
public class SortSentencesTest {

    @Test
    public void sortSentencesByLengthOfLexemesTest() {

        List<String> expectedResult = Arrays.asList(" Мышь."," Мышь, мышь."," Мышь, мышь, мышь." );

        String fileName = ".\\resources\\data\\text2.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);
            List<TextElement> sortedSentenceList = new SortSentences().sort(textComposite);
            List<String> result = new ArrayList<>();
            for (int i=0; i<sortedSentenceList.size(); i++) {
                result.add(sortedSentenceList.get(i).toString());
            }
            Assert.assertEquals(result, expectedResult);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Problem with reading file!");
        }
    }
}
