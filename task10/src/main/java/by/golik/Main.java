package by.golik;

import by.golik.builder.DomBuilder;
import by.golik.builder.FlowersDOMBuilder;
import by.golik.exception.ParserException;


/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws ParserException {

//        DomBuilder domBuilder = new DomBuilder();
//        domBuilder.buildSetFlowers("src/main/resources/data/flowers.xml");
//        System.out.println(domBuilder.getFlowers().toString());

        FlowersDOMBuilder flowersDOMBuilder = new FlowersDOMBuilder();
        flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowersDOMBuilder.getFlowerList().toString());
    }
}
