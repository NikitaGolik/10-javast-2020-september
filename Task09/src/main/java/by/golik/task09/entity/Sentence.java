package by.golik.task09.entity;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Nikita Golik
 */
public class Sentence {
    private List<TextElement> data;

    /**
     * constructor
     */
    public Sentence() {
        data = new LinkedList<TextElement>();
    }

    /**
     * method to add textelemnt to create a sentence
     * @param textElement - element of text
     */
    public void add(TextElement textElement) {
        data.add(textElement);
    }

    public List<TextElement> getData() {
        return data;
    }

    public void setData(List<TextElement> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        if (data == null) {
            return sentence.data == null;
        } else return data.equals(sentence.data);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(TextElement textElement : data) {
            if(!(textElement instanceof Punctuation))sb.append(" ");
            sb.append(textElement.toString());
        }
        return sb.toString().trim();
    }
}
