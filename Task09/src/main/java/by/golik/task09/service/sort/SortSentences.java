package by.golik.task09.service.sort;

import by.golik.task09.bean.TextComposite;
import by.golik.task09.bean.TextElement;
import by.golik.task09.bean.TextElementType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class SortSentences {

    private static final Logger logger = LogManager.getLogger();

    public List<TextElement> sort(TextComposite text) {

        List<TextElement> sentenceList = new ArrayList<>();
        for(TextElement paragraph: text.getTextComponentList()) {
            if(paragraph.getElementType() == TextElementType.PARAGRAPH) {
                TextComposite paragraphComposite = (TextComposite) paragraph;
                for(TextElement sentence: paragraphComposite.getTextComponentList()) {
                    if(sentence.getElementType() == TextElementType.SENTENCE) {
                        sentenceList.add(sentence);
                    }
                }
            }
        }
        List<TextElement> result = new ArrayList<>(sentenceList);
        result.sort(Comparator.comparingInt(sentence -> findLengthOfWords((TextComposite) sentence)));

        return result;
    }

    private int findLengthOfWords(TextComposite sentence) {
        int length = 0;
        for(TextElement word: sentence.getTextComponentList()) {
            if(word.getElementType() == TextElementType.WORD) {
                TextComposite wordComposite = (TextComposite) word;
                for(TextElement leaf: wordComposite.getTextComponentList()) {
                    if(leaf.getElementType() == TextElementType.SYMBOL) {
                        length++;
                    }
                }
            }
        }
        return length;
    }
}
