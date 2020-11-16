package by.golik.task09.entity;

/**
 * @author Nikita Golik
 */
public class RegexForElement {

    // выражение для получения предложений
    public static final String REGEX_SENTENCE = "(?sx-m)[^\\r\\n].*?(?:(?:\\.|\\?|!))";

    // выражение для получения слов и любых знаков включая знаки пунктуации

    //public static final String REGEX_WORD_OR_PUNCTUATION = "([A-Za-zА-Яа-я]+)|(.)";
    public static final String REGEX_WORD_OR_PUNCTUATION = "([A-я]+)|(.)";

    // выражение для получения слова(буквы латинские или русские)
    public static final String REGEX_WORD = "([A-я]+)";

    // выражение для получения символов
    public static final String REGEX_SYMBOL = ".{1}";

    // выражение для получения последовательности пробелов ( > 1 ) в тексте
    public static final String REGEX_SPACES = "(\\s+)";
}
