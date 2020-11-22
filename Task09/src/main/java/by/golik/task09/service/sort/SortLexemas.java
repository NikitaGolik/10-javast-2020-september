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
public class SortLexemas {

    private static final Logger logger = LogManager.getLogger();
    private static final String SYMBOL = "k";

    public List<TextElement> sort(TextComposite text) {

        List<TextElement> lexemaList = new ArrayList<>();

        for(TextElement paragraph: text.getTextComponentList()) {
            if(paragraph.getElementType() == TextElementType.PARAGRAPH) {
                TextElement paragraphComposite = (TextComposite) paragraph;
                for(TextElement sentence: paragraphComposite.getTextComponentList()) {
                    if(sentence.getElementType() == TextElementType.SENTENCE) {
                        TextComposite sentenceComposite = (TextComposite) sentence;
                        for(TextElement lexema: sentenceComposite.getTextComponentList()) {
                            if(lexema.getElementType() == TextElementType.LEXEMA) {
                                lexemaList.add(lexema);
                            }
                        }
                    }
                }
            }
        }
        List<TextElement> result = new ArrayList<>(lexemaList);
        result.sort(comparator.thenComparing(Comparator.comparingInt(lexema -> findNumberOfSymbol((TextComposite) lexema))));
        result.sort(Comparator.comparingInt(lexema -> findNumberOfSymbol((TextComposite) lexema)));
        List<TextElement> reverseResult = new ArrayList<>();
        for(int i=result.size()-1; i>=0; i--) {
            reverseResult.add(result.get(i));
        }
        return reverseResult;
    }

    private int findNumberOfSymbol(TextComposite lexema) {
        int number = 0;
        for(TextElement leaf: lexema.getTextComponentList()) {
            if(leaf.getElementType() == TextElementType.SYMBOL) {
                if(SYMBOL.equals(leaf.toString())) {
                    number++;
                }
            }
        }
        return number;
    }

    private Comparator<TextElement> comparator = new Comparator<TextElement>() {
        @Override
        public int compare(TextElement o1, TextElement o2) {

            int size;
            TextComposite o1Composite = (TextComposite) o1;
            TextComposite o2Composite = (TextComposite) o2;
            if(o2Composite.size() >= o1Composite.size()) {
                size = o1Composite.size();
            }
            else {
                size = o2Composite.size();
            }

            for(int i=0; i<size; i++) {
                TextElement leaf1 = o1Composite.getTextComponentList().get(i);
                TextElement leaf2 = o2Composite.getTextComponentList().get(i);
                if(leaf2.toString().compareTo(leaf1.toString()) != 0) {
                    return leaf2.toString().compareTo(leaf1.toString());
                }
            }
            return 0;
        }
    };
}
