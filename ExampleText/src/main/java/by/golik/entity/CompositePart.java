package by.golik.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class CompositePart implements TextElement {

    private List<TextElement> partList = new ArrayList<TextElement>();

    public CompositePart() {
    }

    @Override
    public void addElement(TextElement part) {
        partList.add(part);

    }


    @Override
    public TextElement getElement(int index) {
        return partList.get(index);
    }

    @Override
    public void parse() {

    }

    @Override
    public String toString() {
        return "CompositePart{" +
                "partList=" + partList +
                '}';
    }
}
