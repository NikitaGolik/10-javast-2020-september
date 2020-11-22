package by.golik.task09.sort;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElement;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.handler.WholeTextParser;
import by.golik.task09.service.sort.SortLexemas;
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
public class SortLexemasTest {
    @Test
    public void sortLexemesBySymbolTest() {

        List<String> expectedResult = Arrays.asList("Aaaa.", "ddmkaaa", "faa.", "Aa.", "Bakd", "A", "B.", "C", "D.", "E");

        String fileName = ".\\resources\\data\\formatted.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);
            List<TextElement> sortedSentenceList = new SortLexemas().sort(textComposite);
            List<String> result = new ArrayList<>();
            for (int i=0; i<sortedSentenceList.size(); i++) {
                result.add(sortedSentenceList.get(i).toString());
            }
            Assert.assertEquals(result, expectedResult);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
