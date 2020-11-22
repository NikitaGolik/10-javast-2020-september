package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.service.exception.*;

/**
 * general interface for all parser of text
 * chain of responsibility
 * @author Nikita Golik
 */
public interface TextParser {

    /**
     * method for parsing text by chose variant
     * @param textComponent - element of text
     * @param text - input text
     * @throws IncorrectInputParametersException if failed to read file
     */
    void parse(TextComposite textComponent, String text) throws IncorrectInputParametersException;
}
