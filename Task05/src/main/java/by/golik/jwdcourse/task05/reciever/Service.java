package by.golik.jwdcourse.task05.reciever;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that describes methods for processing the received text using string and char methods
 */
public class Service {

    /**
     * This method writes the resulting text (after change) to a new file
     * @param newText - resulting text
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public void fileWriter(String newText) throws IOException {
        BufferedWriter output = null;
        try {
            File file = new File("D:\\demo\\newText.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(newText);
        } catch (IOException e) {
            System.out.println("Could not find file " + "D:\\demo\\newText.txt");
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /**
     * 1. In each word, replace the "k"-th letter with the given character.
     * If "k" is greater than the word length, do not correct.
     * @param text - initial text before formatting
     * @param index - serial number of a letter in a word
     * @param symbol - the character we want to change to
     * @return - resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed.
     */

    public String replaceSymbol(String text, int index, char symbol) throws IOException {

        StringBuilder sb = new StringBuilder();
        if (text != null && text.length() > 0 && index > 0) {
            for (String word : text.split(" ")) {
                if (word.length() >= index) {
                    sb.append(word.substring(0, index - 1)).append(symbol).append(word.substring(index, word.length()));
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
        }
        fileWriter(sb.toString());
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 2. In the text after the letter, for example, P, if it is not the last in the word,
     * erroneously typed letter, for example, A, instead of, for example, O. Correct the text.
     * @param text - initial text before formatting
     * @return - resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */

    public String replace(String text) throws IOException {
        StringBuilder sb = new StringBuilder();
        String newText = null;
        if (text != null) {
            for (String word : text.split(" ")) {
                newText = text.replace("ра", "ро");
            }
        }
        fileWriter(newText);
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }

    /**
     * 3. In the text of a word of a given length, replace the specified substring, the length of which may not
     * match the word length.
     * @param text - initial text before formatting
     * @return - resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */
    public String replaceSubstring(String text) throws IOException {

        String[] splitString = text.split(" ");
        String newText = new String();

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() == 5) {
                splitString[i] = text.substring(0, 10);
                newText += splitString[i].concat(" ");
            } else {
                newText += splitString[i].concat(" ");
            }
            fileWriter(newText);
        }
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
     * @return - resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */
    public String deleteAllSymbols(String text) throws IOException {
        String newText = "";

        char[] charText = text.toCharArray();
        for (char ch : charText) {
            //собираем новую строку из символов которые являются буквами и пробелами
            if (Character.isLetter(ch) || Character.isWhitespace(ch))
                newText += ch;
        }
        System.out.print(newText + "\r\n");
        //Между последовательностями подряд идущих букв оставить хотя бы один пробел.
        //разбиваем текст на массив слов, разделитель пробел
        String[] words = newText.split("\\s");
        newText = "";
        for (String st : words) {
            //создаем новую строку только из слов, добавляя разделитель пробел
            if (st.trim().length() > 0)
                newText += st + " ";
        }
        //отрежем последний пробел
        newText = newText.trim();
        fileWriter(newText);
        System.out.println("New Text:");
        System.out.println("");
        System.out.print(newText);

        return text;
    }

    /**
     * 5. Remove from the text all words of a given length beginning with a consonant letter.
     * @param text - initial text before formatting
     * @return - resulting text after formatting
     * @throws IOException if stream to file cannot be written to or closed
     */

    public String remove(String text) throws IOException {

        int charCount = 5;

        String [] words = text.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : words) {
            if(!(isConsonant(s.charAt(0)) && s.length() == charCount)) {
                builder.append(s).append(" ");
            }
        }
        String newText = builder.toString().trim();
        fileWriter(newText);
        System.out.println("New Text:");
        System.out.println("");
        System.out.println(newText);
        return newText;
    }

    /**
     * This method defines consonant and vowel
     * @param c - symbol
     * @return - true, if char c - consonant, else false
     */
    public static boolean isConsonant(char c) {
        switch (Character.toLowerCase(c)) {
            case 'б':
            case 'в':
            case 'г':
            case 'д':
            case 'ж':
            case 'з':
            case 'к':
            case 'л':
            case 'м':
            case 'н':
            case 'п':
            case 'р':
            case 'с':
            case 'е':
            case 'ф':
            case 'х':
            case 'ц':
            case 'ч':
            case 'ш':
            case 'щ':
            case 'b':
            case 'c':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return true;
            default:
                return false;
        }
    }
}