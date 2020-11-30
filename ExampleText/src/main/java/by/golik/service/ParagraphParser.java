package by.golik.service;

import by.golik.entity.CompositePart;
import by.golik.entity.LeafPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
//public class ParagraphParser {
//
//    /**
//     * parse to paragraph
//     * @param wholeText
//     * @param text
//     * @return
//     */
//    private CompositePart parseToParagraph(CompositePart wholeText, String text) {
//
//        CompositePart paragraphList = new CompositePart();
//        Pattern pattertParagraph = Pattern
//                .compile(TextParser.REGEX_PARAGRAPH_WITH_LISTING);
//        LeafPart paragraphLeaf = null;
//        String paragraph = "";
//        //System.out.print(text);
//        Matcher matcher = pattertParagraph.matcher(text);
//        while (matcher.find()) {
//            paragraph = matcher.group();
//            System.out.print(paragraph);
//            if (Pattern.matches(TextParser.REGEX_LISTING, paragraph)) {
//                // if listing - add to list without parsing
//                paragraphLeaf = new LeafPart(paragraph);
//                System.out.print(paragraphLeaf);
//                paragraphList.addElement(paragraphLeaf);
//            } else {
//                System.out.print(paragraph);
//                paragraphList = parseToSentence(paragraphList, paragraph);
//            }
//            wholeText.addElement(paragraphList);
//        }
//
//        return wholeText;
//    }
//
//}
