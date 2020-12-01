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
     *
     */
    public AbstractFlowerBuilder() {
        flowerHashSet = new HashSet<>();
    }

    /**
     *
     * @return
     */
    public HashSet<Flower> getFlowerSet() {
        return flowerHashSet;
    }

    /**
     *
     * @param fileName
     * @throws ParserException
     */
    public abstract void buildFlowerList(String fileName) throws ParserException;
}
