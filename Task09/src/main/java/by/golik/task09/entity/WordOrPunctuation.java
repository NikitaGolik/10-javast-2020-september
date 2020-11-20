package by.golik.task09.entity;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class WordOrPunctuation extends CompositeTextElement {

    private boolean isWord = false;

    public WordOrPunctuation(ComponentType componentType, boolean isWord) {
        super(componentType);
        this.isWord = isWord;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
}
