package by.golik.controller;

import by.golik.builder.FlowerDOMBuilder;
import by.golik.builder.FlowerSaxBuilder;
import by.golik.builder.FlowerStAXBuilder;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;


/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws ParserException, IncorrectInputException {


        FlowerDOMBuilder flowersDOMBuilder = new FlowerDOMBuilder();
        flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowersDOMBuilder.getFlowerSet().toString());

        FlowerSaxBuilder flowerSaxBuilder = new FlowerSaxBuilder();
        flowerSaxBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowerSaxBuilder.getFlowerSet());

        FlowerStAXBuilder flowerStAXBuilder = new FlowerStAXBuilder();
        flowerStAXBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowerStAXBuilder.getFlowerSet());


    }
}
