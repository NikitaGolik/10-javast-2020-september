package by.golik.service;

import by.golik.entity.CompositePart;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
//public class WordSignParser  {
//
//    /**
//     * parse to sign and word
//     * @param wordList
//     * @param word
//     * @return
//     */
//    private CompositePart parseToSignAndWord(CompositePart wordList, String word) {
//
//        Pattern pattern = Pattern.compile(TextParser.REGEX_WORD_AND_SIGN);
//        String wordSign = "";
//        Matcher matcher = pattern.matcher(word);
//        CompositePart wordSignList = new CompositePart();
//        while (matcher.find()) {
//            wordSign = matcher.group();
//            wordSignList = parseToSymbol(wordSignList, wordSign);
//            wordList.addElement(wordSignList);
//        }
//        return wordList;
//    }
//}
