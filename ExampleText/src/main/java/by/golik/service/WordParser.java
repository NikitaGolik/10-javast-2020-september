package by.golik.service;

import by.golik.entity.CompositePart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
//public class WordParser {
//    /**
//     * parse to word
//     * @param sentenceList
//     * @param sentence
//     * @return
//     */
//    private CompositePart parseToWord(CompositePart sentenceList,
//                                      String sentence) {
//
//        Pattern pattertWord = Pattern.compile(TextParser.REGEX_WORD);
//        String word = "";
//        Matcher matcher = pattertWord.matcher(sentence);
//        CompositePart wordList = new CompositePart();
//        while (matcher.find()) {
//            word = matcher.group();
//            //System.out.print(word);
//            wordList = parseToSignAndWord(wordList, word);
//            sentenceList.addElement(wordList);
//        }
//        return sentenceList;
//    }
//}
