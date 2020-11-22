package by.golik.task09.sort;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElement;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.WholeTextParser;
import by.golik.task09.service.query.SortParagraphes;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        List<String> expectedResult = Arrays.asList(" Hello.", " Hello Hello.", " Hello Hello Hello. Hello.",
                " Hello Hello. Hello. Hello Hello.");

        String fileName = "data/forSortParagraphsByNumberOfSentencesTest.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);
            List<TextElement> sortedParagraphList = new SortParagraphsByNumberOfSentences().sort(textComposite);
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
