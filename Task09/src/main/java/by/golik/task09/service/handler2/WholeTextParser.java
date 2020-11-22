package by.golik.task09.service.handler2;

import by.golik.task09.entity.CompositeTextElement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WholeTextParser implements TextParser {

    private static final Logger LOGGER = LogManager.getLogger();

    private ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public void parse(CompositeTextElement wholeText, String text) {

        paragraphParser.parse(wholeText, text);
        LOGGER.log(Level.INFO, "- Text is successfully taken apart.");
    }
}
