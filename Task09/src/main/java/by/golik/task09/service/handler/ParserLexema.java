package by.golik.task09.service.handler;

import by.golik.task09.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class ParserLexema extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);



    private static final String REGEX_LEXEMA_WITH_EXPRESSION = "(\\W+)?(\\w+)?(\\W+)?";

    public ParserLexema(AbstractParser nextParser) {
        this.nextParser = nextParser;
        this.componentType = ComponentType.LEXEMA;
        super.regEx = REGEX_LEXEMA_WITH_EXPRESSION;
    }

    @Override
    public List<String> findElementsByRegex(String text, String regEx) {
        List<String> splitedList = new ArrayList<>();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            logger.info("Matcher has found {}", matcher.toString());
            if (matcher.group(1)!=null){ splitedList.add(matcher.group(1)); } //expression
            logger.info("group1: {}", matcher.group(1));
            if (matcher.group(2)!=null){ splitedList.add(matcher.group(2)); } // word
            logger.info("group2: {}", matcher.group(2));
            if (matcher.group(3)!=null){ splitedList.add(matcher.group(3)); } // expression
            logger.info("group3: {}", matcher.group(3));
        }

        logger.info("split by regex in lexemaParser returns following list: {}", Arrays.asList(splitedList));
        return splitedList;
    }
}
