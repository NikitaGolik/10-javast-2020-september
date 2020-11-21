package by.golik.task09.service.handler2;

import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;

/**
 * @author Nikita Golik
 */
public interface TextParser {

    void parse(CompositeTextElement textComponent, String text) throws IncorrectInputParametersException;

}
