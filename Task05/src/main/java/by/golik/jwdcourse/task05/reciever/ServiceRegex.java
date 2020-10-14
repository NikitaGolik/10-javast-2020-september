package by.golik.jwdcourse.task05.reciever;
import java.io.IOException;

/**
 * A class that describes methods for processing the received text using regular expressions
 */
public class ServiceRegex {
    Service service;

    /**
     * 1. In each word, replace the "k"-th letter with the given character.
     * If "k" is greater than the word length, do not correct.
     * @param text - initial text before formatting
     * @param index - number of letter in word
     * @param symbol - symbol in which letter will be changed
     * @return resulting text after formatting
     */
    public String replaceSymbolRegex(String text, int index, char symbol) {
        String newText = null;
        /**
         * \b assert position at a word boundary
         * \p{L} matches any kind of letter from any language
         * {%d} matches the characters {%d} literally (case sensitive)
         */
        newText = text.replaceAll(String.format("(\\b\\p{L}{%d})\\p{L}", index - 1), "$1" + symbol);
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }
    //TODO

    /**
     * 2. In the text after the letter, for example, P, if it is not the last in the word,
     * erroneously typed letter, for example, A, instead of, for example, O. Correct the text.
     * @param text - initial text before formatting
     * @return resulting text after formatting
     */
    public String replaceRegex(String text) {
        String newText = null;
        /**
         * \B assert position where \b does not match
         * ра matches a single character in the list ра (case sensitive)
         */
        newText = text.replaceAll("\\B[ра]\\B", "ро");
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }

    /**
     * 3. In the text of a word of a given length, replace the specified substring, the length of which may not
     * match the word length.
     * @param text - initial text before formatting
     * @return resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */

    public String replaceSubstringRegex (String text) throws IOException {
        String newText = null;
        /**
         * \b assert position at a word boundary
         * {5} Quantifier — Matches exactly 5 times
         * a-z a single character in the range between a and z
         * A-Z a single character in the range between A and Z
         */
        newText = text.replaceAll("\\b[a-zA-Z]{5}\\b", "JAVA");
        service.fileWriter(newText);
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }

    /**
     * 4. Remove all characters except spaces from small (* large ~ 10Gb) text,
     * not letters (both Russian and English). Between sequences of consecutive letters
     * leave one space (= remove extra spaces).
     * @param text - initial text before formatting
     * @return resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */

    public String deleteAllSymbolsRegex(String text) throws IOException {
        String newText = null;
        /**
         * ?u- unicode
         * ^ - start of string
         *  \ p -  it's the opposite of \p, all "non-letters".
         */
        newText =  text.replaceAll("(?u)[^\\pL ]","");
        service.fileWriter(newText);
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }

    /**
     * 5. Remove from the text all words of a given length beginning with a consonant letter.
     * @param text -initial text before formatting
     * @return resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */

    //TODO DOESN'T WORK (consonant)

    public String deleteWordsRegex(String text) throws IOException {
        String newText = null;
        /**
         * \b - word boundary
         * \w - all words
         * {5} - count of letters in word
         *
         */
        newText = text.replaceAll("\\b\\w{5,5}\\b", "");
        service.fileWriter(newText);
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }

}
