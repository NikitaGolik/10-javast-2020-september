package by.golik.task09.service.handler2;

import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.logging.Level;

/**
 * @author Nikita Golik
 */
public class WholeTextParser implements TextParser {

    private static final Logger logger = LogManager.getLogger();

    private ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public void parse(CompositeTextElement wholeText, String text) throws IncorrectInputParametersException {

        paragraphParser.parse(wholeText, text);
       logger.info("- Text is successfully taken apart.");
    }
}
