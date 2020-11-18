package by.golik.task09.entity;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class WordOrPunctuation extends CompositeTextElement {

    private boolean isWord = false;


    public WordOrPunctuation(List<Symbol> elementList) {
        super(elementList);
    }

    public WordOrPunctuation(List<Symbol> elementList, boolean isWord) {
        super(elementList);
        this.isWord = isWord;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
}
