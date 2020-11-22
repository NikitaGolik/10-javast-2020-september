package by.golik.task09.composite;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElementType;
import by.golik.task09.reader.TextReader;
import by.golik.task09.service.handler.WholeTextParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.golik.task09.service.exception.*;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;


/**
 * @author Nikita Golik
 */
public class CompositeTest {

    @Test
    public void textCompositeToStringTest() {

        String expectedText = "\t It has survived - not only (five) centuries, but also the leap into 13+i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5---j+4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\t It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n" +
                "\t It is a (-5+1/2*(2+5*2---j))*1200 established fact that a reader will be of a page when looking at its layout.\n" +
                "\t Bye.\n";

        String fileName = ".\\resources\\data\\text.txt";
        File file = new File(fileName);
        try {
            String wholeText = new TextReader().read(file);
            TextComposite textComposite = new TextComposite(TextElementType.TEXT);
            new WholeTextParser().parse(textComposite, wholeText);
            String newText = textComposite.toString();
            Assert.assertEquals(newText, expectedText);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
