package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.service.exception.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public class WholeTextParser implements TextParser {

    private static final Logger LOGGER = LogManager.getLogger();

    private ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public void parse(TextComposite wholeText, String text) throws IncorrectInputParametersException {

        paragraphParser.parse(wholeText, text);
        LOGGER.log(Level.INFO, "- Text is successfully taken apart.");
    }
}
