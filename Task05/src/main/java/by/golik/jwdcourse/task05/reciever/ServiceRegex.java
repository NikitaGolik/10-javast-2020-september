package by.golik.jwdcourse.task05.reciever;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class ServiceRegex {
    Service service;
    ConsoleReader consoleReader;

    /**
     *1.	В каждом слове k-ю букву заменить заданным символом.
     * Если k больше длины слова, корректировку не выполнять.
     * @return
     */
    public String replaceSymbolRegex(String text, int index, char symbol) {
        String newText = null;
        newText = text.replaceAll(String.format("(\\b\\p{L}{%d})\\p{L}", index - 1), "$1" + symbol);
        System.out.println(newText);
        return newText;
    }
    //TODO
    /**
     * 2.   В тексте после буквы, например, Р, если она не последняя в слове,
     * ошибочно напечатана буква, например,  А,  вместо, например, О. Внести исправления в текст.
     * @return
     */
    public String replaceRegex(String text) {
        String newText = null;
        newText = text.replaceAll("\\B[ра]\\B", "ро");
        System.out.println(newText);
        return newText;
    }
    /**
     * 3.	В тексте слова заданной длины заменить указанной подстрокой, длина которой может не
     * совпадать с длиной слова. (дом -> домик -> хата)
     * @param text
     */

    public String replaceSubstringRegex (String text) throws IOException {
        String newText = null;
        newText = text.replaceAll("\\b[a-zA-Z]{5}\\b", "JAVA");
        service.fileWriter(newText);
        System.out.println(newText);
        return newText;
    }
    /**
     * 4.	Из небольшого (*большого ~ 10Gb) текста удалить все символы, кроме пробелов,
     * не являющиеся буквами (и рус и англ). Между последовательностями подряд идущих букв
     * оставить один пробел (= удалить лишние пробелы).
     * @param text
     */

    public String deleteSymbolsRegex (String text) throws IOException {
        String newText = null;
        newText =  text.replaceAll("(?u)[^\\pL ]","");
        service.fileWriter(newText);
        System.out.println(newText);
        return newText;
    }

    /**
     * 5.	Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
     * @param text
     * @return
     */
    //TODO DOESN'T WORK
    public String deleteWordsRegex(String text) {
        

        return text;
    }

}
