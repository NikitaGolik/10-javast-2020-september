package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;


/**
 * @author Nikita Golik
 */
public class ParserText extends AbstractParser {
    private static final String REGEX = ".+"; // split to paragraphs \\s{4}.+

    public ParserText (AbstractParser nextParser){
        this.nextParser=nextParser;
        this.componentType = ComponentType.TEXT;
        super.regEx =REGEX;
    }


}
