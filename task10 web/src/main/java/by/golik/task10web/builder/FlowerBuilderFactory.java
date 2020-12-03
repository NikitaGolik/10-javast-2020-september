package by.golik.task10web.builder;

import by.golik.task10web.exception.IncorrectInputException;

/**
 * @author Nikita Golik
 */
public class FlowerBuilderFactory {

    /**
     * realization of bulider factory
     * @param type - type of parser
     * @return - chosen parser
     * @throws IncorrectInputException - if input is incorrect
     */
    public AbstractFlowerBuilder createFlowerBuilder(String type) throws IncorrectInputException {

        BuilderTypes builderTypes = BuilderTypes.valueOf(type);

        switch (builderTypes) {
            case DOM:
                return new FlowerDOMBuilder();
            case SAX:
                return new FlowerSAXBuilder();
            case STAX:
                return new FlowerStAXBuilder();
            default:
                throw new IncorrectInputException(type + "is incorrect");
        }
    }
}
