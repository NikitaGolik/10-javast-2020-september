package by.golik.task09.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 * @author Nikita Golik
 */
public class Text {
    private List<Sentence> data;

    /**
     * constructor
     */
    public Text() {
        data = new LinkedList<>();
    }
    public void add(Sentence sentence) {
        data.add(sentence);
    }

    public List<Sentence> getData() {
        return data;
    }

    public void setData(List<Sentence> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        if(data == null) {
            return text.data == null;
        } else return data.equals(text.data);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime +((data != null) ? 0 : data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Sentence sentence : data) {
            sb.append(sentence.toString() + " ");
        }
        return sb.toString().trim();
    }
}
