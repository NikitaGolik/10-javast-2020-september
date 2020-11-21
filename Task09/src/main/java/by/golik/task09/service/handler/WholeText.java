package by.golik.task09.service.handler;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public class WholeText extends AbstractParser {

    private static final Logger logger = LogManager.getLogger();

    public WholeText(AbstractParser wholeText, String text) {
        this.nextParser = wholeText;
        this.componentType = ComponentType.TEXT;
        logger.info("- Text is parsed.");
    }
}
