package by.golik.task09.service.handler;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.service.exception.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class parser text
 * @author Nikita Golik
 */
public class WholeTextParser implements TextParser {

    private static final Logger logger = LogManager.getLogger();

    private ParagraphParser paragraphParser = new ParagraphParser();

    /**
     *
     * @param wholeText - text
     * @param text - String value of input text
     * @throws IncorrectInputParametersException
     */
    @Override
    public void parse(TextComposite wholeText, String text) throws IncorrectInputParametersException {

        paragraphParser.parse(wholeText, text);
        logger.log(Level.INFO, "- Text is successfully taken apart.");
    }
}
