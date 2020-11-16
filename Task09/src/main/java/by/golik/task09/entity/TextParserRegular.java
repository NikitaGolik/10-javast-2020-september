package by.golik.task09.entity;



/**
 * @author Nikita Golik
 */
public class TextParserRegular {

    public static final String REGEX_LISTING = "\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITH_LISTING = "(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITHOUT_LISTING = "\\t(.+))([^((Start listing)([^\\t]+)(End listing))]";
    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    public static final String REGEX_EMPTY = ".]*";

}
