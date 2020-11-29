package by.golik.builder;

import by.golik.entity.Flower;
import by.golik.exception.ParserException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public abstract class AbstractFlowerBuilder {
    protected List<Flower> firstFlowerList;

    public AbstractFlowerBuilder() {
        firstFlowerList = new ArrayList<>();
    }

    public List<Flower> getFlowerList() {
        return firstFlowerList;
    }
    public abstract void buildFlowerList(String fileName) throws ParserException;
}
