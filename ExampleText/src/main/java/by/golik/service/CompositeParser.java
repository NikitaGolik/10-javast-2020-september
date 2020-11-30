package by.golik.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Nikita Golik
 */
public abstract class CompositeParser {

    private static final Logger logger = LogManager.getLogger(CompositeParser.class);

    /**
     * nextParser - next object of AbstractParser that do parse of text line
     * textComponent - branch of Composite this parse method do its job for.
     * componentType - type of Composite object we parse for
     * regEx - regular expression to split string line;
     */

    protected CompositeParser nextParser;
    protected Component textComponent;
    protected ComponentType componentType;
    protected String regEx;

    /**
     * Split String line with regards to regular expression of current parser
     * and returns list of string after split operation.
     * @param text - text need to split
     * @param regEx - regular expression text split with
     * @return - list of string after split operation
     */

    public List<String> splitByRegex (String text, String regEx){

        List<String> splitedList = new ArrayList<>();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            splitedList.add(matcher.group());
        }
        logger.info("text has been splited to parser to: {} in ckass: {}", Arrays.asList(splitedList), getClass().getSimpleName());
        return splitedList;
    }

    /**
     * Function converting String line to Composite element representing by Interface
     * @see Component;
     * @param text - text need to parse to component element
     * @return - Component object (Composite or leaf) with regards to componentType;
     * @throws CompositeException
     */

    public Component parse(String text) throws CompositeException {

        List<String> stringSymbols = this.splitByRegex(text,regEx);
        textComponent = new Composite(componentType);

        if (nextParser!=null){
            for (String param : stringSymbols){
                textComponent.add(nextParser.parse(param));
                logger.info("compontnt {} has been added to {} componentList", param, this.getClass().getSimpleName());
            }
        }

        return textComponent;
    }
}
