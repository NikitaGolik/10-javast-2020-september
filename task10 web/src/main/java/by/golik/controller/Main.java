package by.golik.controller;

import by.golik.builder.*;
import by.golik.entity.Flower;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;

import java.util.HashSet;


/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws ParserException, IncorrectInputException {

//        FlowerBuilderFactory factory = new FlowerBuilderFactory();
//        AbstractFlowerBuilder builder = null;
//
//        builder = factory.createFlowerBuilder("DOM");
//        System.out.println(builder.getFlowerSet());


        FlowerDOMBuilder flowersDOMBuilder = new FlowerDOMBuilder();
        flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(flowersDOMBuilder.getFlowerSet());

//        FlowerSaxBuilder flowerSaxBuilder = new FlowerSaxBuilder();
//        flowerSaxBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
//        System.out.println(flowerSaxBuilder.getFlowerSet());
//
//        FlowerStAXBuilder flowerStAXBuilder = new FlowerStAXBuilder();
//        flowerStAXBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
//        System.out.println(flowerStAXBuilder.getFlowerSet());


    }
}
