package by.golik.entity;

import java.util.Iterator;

/**
 * @author Nikita Golik
 */
public interface TextElement {

        public void addElement(TextElement part);

        public TextElement getElement(int index);

        public void parse();
}
