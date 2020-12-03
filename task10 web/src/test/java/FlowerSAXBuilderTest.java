import by.golik.builder.AbstractFlowerBuilder;
import by.golik.builder.FlowerBuilderFactory;
import by.golik.builder.FlowerDOMBuilder;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Nikita Golik
 */
public class FlowerSAXBuilderTest {
    @Test
    public void parse() throws ParserException, IncorrectInputException {
        FlowerBuilderFactory flowerBuilderFactory = new FlowerBuilderFactory();
        AbstractFlowerBuilder abstractFlowerBuilder = flowerBuilderFactory.createFlowerBuilder("SAX");
        abstractFlowerBuilder.buildFlowerList("data/flowers.xml");

        Assert.assertEquals(abstractFlowerBuilder.getFlowerSet().size(), 16);
    }
}
