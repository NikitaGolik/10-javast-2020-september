package by.golik.task09.composite;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.put.ReaderFile;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author Nikita Golik
 */
public class CompositeTest {

    @Test
    public void textCompositeToStringTest() throws IncorrectInputParametersException {

        String expectedText = "It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 30>>>3 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\t\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n" +
                "\tIt is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.\n" +
                "\tBye.\n";

        String fromFileName = ".\\resources\\data\\text.txt";

        String wholeText = new ReaderFile().readFromFile(fromFileName);
        CompositeTextElement textComposite = new CompositeTextElement(ComponentType.TEXT);

        String newText = textComposite.toString();
        Assert.assertEquals(newText, expectedText);
        Assert.assertEquals(newText, expectedText);
    }
}
