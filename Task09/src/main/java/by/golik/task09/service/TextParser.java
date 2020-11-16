package by.golik.task09.service;

import by.golik.task09.entity.Punctuation;
import by.golik.task09.entity.Sentence;
import by.golik.task09.entity.Text;
import by.golik.task09.entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class TextParser {

    public static Text parseText(String text){

        Text result = new Text();
        Pattern endOfSentence = Pattern.compile("[.!?]{1,3}");
        String trimmedText = trim(text);
        Matcher matcher = endOfSentence.matcher(trimmedText);
        int prewSent = 0;
        while (matcher.find()) {
            result.add(parseSentence(trimmedText.substring(prewSent, matcher.end())));
            prewSent = matcher.end();
        }
        return result;
    }

    private static String trim(String text){
        return text.replaceAll("[\\s]", " ");
    }

    public static Sentence parseSentence(String sentence) {
        Sentence result = new Sentence();
        String[] splited = sentence.trim().split(" ");

        //Pattern punct = Pattern.compile("[\\,\\:\\;\\-\\!\\?\\.\\']{1,3}$");

        Pattern punct = Pattern.compile("[\\W]{1,3}");
        for (String string : splited) {
            Matcher matcher = punct.matcher(string);
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    result.add(new Punctuation(matcher.group()));
                    result.add(new Word(string.substring(matcher.end(), string.length())));
                } else if (matcher.end() == string.length()) {
                    result.add(new Word(string.substring(0, matcher.start())));
                    result.add(new Punctuation(matcher.group()));
                } else {
                    result.add(new Word(string));
                }
            } else {
                result.add(new Word(string));
            }
        }
        return result;
    }
}
