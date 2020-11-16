package by.golik.task09.entity;

/**
 * @author Nikita Golik
 */
public class Word extends TextElement {

    public Word() {
    }

    public Word(String s) {
        super(s);
    }

    /**
     * method to find the beginning of word
     * @return first letter of a word
     */
    public Character getFirstLetter() {
        if (this.getData().isEmpty()) {
            return null;
        } return this.getData().get(0).getData();
    }
}
