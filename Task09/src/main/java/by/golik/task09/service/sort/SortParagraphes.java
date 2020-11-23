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
public class SortParagraphes {

    private static final Logger logger = LogManager.getLogger();

    public List<TextElement> sort(TextComposite text) {

        List<TextElement> paragraphList = new ArrayList<>();
        for(TextElement paragraph: text.getTextComponentList()) {
            if(paragraph.getElementType() == TextElementType.PARAGRAPH) {
                paragraphList.add(paragraph);
            }
        }
        List<TextElement> result = new ArrayList<>(paragraphList);
        result.sort(Comparator.comparingInt(paragraph -> findNumberOfSentences((TextComposite) paragraph)));

        return result;
    }

    private int findNumberOfSentences(TextComposite paragraph) {
        int count = 0;
        for(TextElement sentence: paragraph.getTextComponentList()) {
            if(sentence.getElementType() == TextElementType.SENTENCE) {
                count++;
            }
        }
        return count;
    }
}
