package by.golik.task09.service;


import by.golik.task09.bean.TextComposite;
import by.golik.task09.service.exception.*;

public interface TextParser {

    void parse(TextComposite textComponent, String text) throws IncorrectInputParametersException, IncorrectInputParametersException;
}
