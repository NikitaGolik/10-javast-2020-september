package by.golik.builder;

import by.golik.exception.IncorrectInputException;

/**
 * @author Nikita Golik
 */
public class FlowerBuilderFactory {

    public AbstractFlowerBuilder createFlowerBuilder(String type) throws IncorrectInputException {

        BuilderTypes builderTypes = BuilderTypes.valueOf(type);

        switch (builderTypes) {
            case DOM:
                return new FlowersDOMBuilder();
            case SAX:
                return new SaxBuilder();
            default:
                throw new IncorrectInputException(type + "is incorrect");
        }
    }
}
