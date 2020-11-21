package by.golik.task09.sort;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.put.ReaderFile;
import by.golik.task09.service.query.SortParagraphes;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class SortParagraphesTest {

    @Test
    public void sortParagraphsByNumberOfSentencesTest() {

        List<String> expectedResult = Arrays.asList(" Привет.", " Привет. Привет", " Привет. Привет. Привет.");

        String fromFileName = ".\\resources\\data\\paragraph.txt";


            String wholeText = new ReaderFile().readFromFile(fromFileName);
            CompositeTextElement textComposite = new CompositeTextElement(ComponentType.TEXT);

            List<TextElement> sortedParagraphList = new SortParagraphes().sort(textComposite);
            List<String> result = new ArrayList<>();
            for (int i=0; i<sortedParagraphList.size(); i++) {
                result.add(sortedParagraphList.get(i).toString());
            }
            Assert.assertEquals(result, expectedResult);

    }
}
