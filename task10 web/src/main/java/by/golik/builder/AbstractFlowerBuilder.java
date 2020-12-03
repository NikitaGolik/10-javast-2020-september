package by.golik.builder;

import by.golik.entity.Flower;
import by.golik.exception.ParserException;

import java.util.HashSet;

/**
 * @author Nikita Golik
 */
public abstract class AbstractFlowerBuilder {

    protected HashSet<Flower> flowerHashSet;

    /**
     * constructor
     */
    public AbstractFlowerBuilder() {
        flowerHashSet = new HashSet<>();
    }


    public HashSet<Flower> getFlowerSet() {
        return flowerHashSet;
    }

    /**
     * Method to create list of flowers from xml file
     * @param fileName - name of xml file
     * @throws ParserException - exception during parsing
     */
    public abstract void buildFlowerList(String fileName) throws ParserException;
}
