import by.golik.builder.AbstractFlowerBuilder;
import by.golik.builder.FlowerBuilderFactory;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Nikita Golik
 */
public class FlowerStAXBuilderTest {
    @Test
    public void parse() throws ParserException, IncorrectInputException {
        FlowerBuilderFactory flowerBuilderFactory = new FlowerBuilderFactory();
        AbstractFlowerBuilder abstractFlowerBuilder = flowerBuilderFactory.createFlowerBuilder("STAX");
        abstractFlowerBuilder.buildFlowerList("D:\\eclipse-workspace\\10-javast-2020-september\\task10 web\\src\\main\\resources\\data\\flowers.xml");

        Assert.assertEquals(abstractFlowerBuilder.getFlowerSet().size(), 16);

    }
}
