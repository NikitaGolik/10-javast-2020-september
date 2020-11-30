package by.golik.service;

import by.golik.entity.CompositePart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
//public class SentenceParser {
//
//    /**
//     * parse to sentence
//     * @param paragraphList
//     * @param paragraph
//     * @return
//     */
//    private CompositePart parseToSentence(CompositePart paragraphList,
//                                          String paragraph) {
//
//        CompositePart sentenceList = new CompositePart();
//        Pattern pattertSentence = Pattern.compile(TextParser.REGEX_SENTENCE);
//        Matcher m2 = pattertSentence.matcher(paragraph);
//        String sentence = "";
//        while (m2.find()) {
//            sentence = m2.group();
//            sentenceList = parseToWord(sentenceList, sentence);
//            // System.out.print(sentence);
//            paragraphList.addElement(sentenceList);
//        }
//        return paragraphList;
//    }
//}
