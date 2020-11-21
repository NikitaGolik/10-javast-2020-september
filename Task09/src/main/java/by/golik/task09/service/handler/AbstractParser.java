package by.golik.task09.service.handler;

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
public abstract class AbstractParser {

    private static final Logger logger = LogManager.getLogger(AbstractParser.class);

    protected AbstractParser nextParser;
    CompositeTextElement compositeTextElement;
    ComponentType componentType;
    String regEx;


    public List<String> findElementsByRegex (String text, String regEx){

        List<String> elementList = new ArrayList<>();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            elementList.add(matcher.group());
        }
        logger.info("text has been added to parser " + Arrays.asList(elementList) + " in class: " +
                getClass().getSimpleName());
        return elementList;
    }

    public TextElement parse(String text)  {

        List<String> symbolList = this.findElementsByRegex(text,regEx);
        compositeTextElement = new CompositeTextElement(componentType);

        if (nextParser!=null){
            for (String s : symbolList){
                compositeTextElement.add(nextParser.parse(s));
                logger.info("component " + s + " has been added to " + this.getClass().getSimpleName());
            }
        }

        return compositeTextElement;
    }

}
