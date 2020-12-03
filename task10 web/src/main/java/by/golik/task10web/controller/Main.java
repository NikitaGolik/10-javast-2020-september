package by.golik.task10web.controller;

import by.golik.task10web.builder.*;
import by.golik.task10web.exception.IncorrectInputException;
import by.golik.task10web.exception.ParserException;



/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws ParserException, IncorrectInputException {


        FlowerDOMBuilder flowersDOMBuilder = new FlowerDOMBuilder();
        flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowersDOMBuilder.getFlowerSet());

        FlowerSAXBuilder flowerSaxBuilder = new FlowerSAXBuilder();
        flowerSaxBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowerSaxBuilder.getFlowerSet());

        FlowerStAXBuilder flowerStAXBuilder = new FlowerStAXBuilder();
        flowerStAXBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowerStAXBuilder.getFlowerSet());


    }
}
