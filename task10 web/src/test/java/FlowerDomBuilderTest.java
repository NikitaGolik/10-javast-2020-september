import by.golik.task10web.builder.AbstractFlowerBuilder;
import by.golik.task10web.builder.FlowerBuilderFactory;
import by.golik.task10web.exception.IncorrectInputException;
import by.golik.task10web.exception.ParserException;
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
        abstractFlowerBuilder.buildFlowerList("D:\\eclipse-workspace\\10-javast-2020-september\\task10 web\\src\\main\\resources\\data\\flowers.xml");

        Assert.assertEquals(abstractFlowerBuilder.getFlowerSet().size(), 16);
    }
}
