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
public class SortSentences {
    public List<TextElement> sort(CompositeTextElement text) {

        List<TextElement> sentenceList = new ArrayList<>();
        for(TextElement paragraph: text.getElementList()) {
            if(paragraph.getComponentType() == ComponentType.PARAGRAPH) {
                CompositeTextElement paragraphComposite = (CompositeTextElement) paragraph;
                for(TextElement sentence: paragraphComposite.getElementList()) {
                    if(sentence.getComponentType() == ComponentType.SENTENCE) {
                        sentenceList.add(sentence);
                    }
                }
            }
        }
        List<TextElement> result = new ArrayList<>(sentenceList);
        result.sort(Comparator.comparingInt(sentence -> findLengthOfWords((CompositeTextElement) sentence)));

        return result;
    }

    private int findLengthOfWords(CompositeTextElement sentence) {
        int length = 0;
        for(TextElement word: sentence.getElementList()) {
            if(word.getComponentType() == ComponentType.WORD) {
                CompositeTextElement wordComposite = (CompositeTextElement) word;
                for(TextElement leaf: wordComposite.getElementList()) {
                    if(leaf.getComponentType() == ComponentType.SYMBOL) {
                        length++;
                    }
                }
            }
        }
        return length;
    }
}
