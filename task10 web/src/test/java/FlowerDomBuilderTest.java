import by.golik.builder.AbstractFlowerBuilder;
import by.golik.builder.FlowerBuilderFactory;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Nikita Golik
 */
public class FlowerDomBuilderTest {
    @Test
    public void parse() throws IncorrectInputException, ParserException {
        FlowerBuilderFactory flowerBuilderFactory = new FlowerBuilderFactory();
        AbstractFlowerBuilder abstractFlowerBuilder = flowerBuilderFactory.createFlowerBuilder("DOM");
        abstractFlowerBuilder.buildFlowerList("data/flowers.xml");

        Assert.assertEquals(abstractFlowerBuilder.getFlowerSet().size(), 16);
    }
}
