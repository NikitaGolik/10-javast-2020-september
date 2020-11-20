package by.golik.task09.service.handler;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Nikita Golik
 */
public class ParserText extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserText.class);
    private static final String REGEX = ".+"; // split to paragraphs \\s{4}.+

    public ParserText (AbstractParser nextParser){
        this.nextParser=nextParser;
        this.componentType = ComponentType.TEXT;
        super.regEx =REGEX;
        logger.info("- Text is successfully taken apart.");
    }


}
