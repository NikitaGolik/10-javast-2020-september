package by.golik.task09.service.handler2;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;
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
public class AbstractParser {

    private static final Logger logger = LogManager.getLogger(AbstractParser.class);

    protected AbstractParser nextParser;
    CompositeTextElement compositeTextElement;
    ComponentType componentType;
    String regEx;

    public List<String> splitByRegex (String text, String regEx){

        List<String> splitedList = new ArrayList<>();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            splitedList.add(matcher.group());
        }
        logger.info("text has been splitted to parser to: {} in class: {}", Arrays.asList(splitedList), getClass().getSimpleName());
        return splitedList;
    }

    public TextElement parse(String text)  {

        List<String> stringSymbols = this.splitByRegex(text,regEx);
        compositeTextElement = new CompositeTextElement(componentType);

        if (nextParser!=null){
            for (String param : stringSymbols){
                compositeTextElement.add(nextParser.parse(param));
                logger.info("component {} has been added to {} componentList", param, this.getClass().getSimpleName());
            }
        }

        return compositeTextElement;
    }

}
