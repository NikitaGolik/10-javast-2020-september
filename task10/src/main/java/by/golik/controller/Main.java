package by.golik.controller;

import by.golik.builder.SaxBuilder;
import by.golik.exception.ParserException;


/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws ParserException {

//        FlowersDOMBuilder flowersDOMBuilder = new FlowersDOMBuilder();
//        flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
//        System.out.println(flowersDOMBuilder.getFlowerList().toString());

        SaxBuilder saxBuilder = new SaxBuilder();
        saxBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        System.out.println(saxBuilder.getFlowerList());


    }
}
