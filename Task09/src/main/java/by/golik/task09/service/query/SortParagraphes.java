package by.golik.task09.service.query;

import by.golik.task09.entity.ComponentType;
import by.golik.task09.entity.CompositeTextElement;
import by.golik.task09.entity.TextElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class SortParagraphes {

    private int findNumberOfSentences(CompositeTextElement paragraph) {
        int count = 0;
        for(TextElement sentence: paragraph.getElementList()) {
            if(sentence.getComponentType() == ComponentType.SENTENCE) {
                count++;
            }
        }
        return count;
    }

    public List<TextElement> sort(CompositeTextElement text) {

        List<TextElement> paragraphList = new ArrayList<>();
        for(TextElement paragraph: text.getElementList()) {
            if(paragraph.getComponentType() == ComponentType.PARAGRAPH) {
                paragraphList.add(paragraph);
            }
        }
        List<TextElement> result = new ArrayList<>(paragraphList);
        result.sort(Comparator.comparingInt(paragraph -> findNumberOfSentences((CompositeTextElement) paragraph)));

        return result;
    }
}
