package by.golik.task.parser;


import by.golik.task.bean.TextComposite;
import by.golik.task.exception.IncorrectInputParametersException;

public interface TextParser {

    void parse(TextComposite textComponent, String text) throws IncorrectInputParametersException;
}
