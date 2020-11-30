package by.golik.builder;

import by.golik.exception.IncorrectInputException;

/**
 * @author Nikita Golik
 */
public class FlowerBuilderFactory {

    /**
     *
     * @param type
     * @return
     * @throws IncorrectInputException
     */
    public AbstractFlowerBuilder createFlowerBuilder(String type) throws IncorrectInputException {

        BuilderTypes builderTypes = BuilderTypes.valueOf(type);

        switch (builderTypes) {
            case DOM:
                return new FlowerDOMBuilder();
            case SAX:
                return new FlowerSaxBuilder();
            case STAX:
                return new FlowerStAXBuilder();
            default:
                throw new IncorrectInputException(type + "is incorrect");
        }
    }
}
