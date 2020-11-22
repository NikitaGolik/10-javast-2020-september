package by.golik.task09.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * this class describes building a tree of elements of text.
 * All linker operations are based on recursion and "summing" results on the branches of the tree.
 * @author Nikita Golik
 */
public class TextComposite implements TextElement {

    private List<TextElement> textComponentList = new LinkedList<>();
    private TextElementType elementType;

    /**
     * constructor to create element of text
     * @param elementType - type of text element
     */
    public TextComposite(TextElementType elementType) {
        this.elementType = elementType;
    }

    /**
     * getter for all element of concrete type
     * @return list of elements of concrete type
     */
    public List<TextElement> getTextComponentList() {
        return textComponentList;
    }

    /**
     * @return size of list of elements
     */
    public int size() {
        return textComponentList.size();
    }

    /**
     * to add new text element to general list
     * @param textComponent - elemnt of concrety type of text
     */
    public void add(TextElement textComponent) {
        textComponentList.add(textComponent);
    }

    @Override
    public TextElementType getElementType() {
        return elementType;
    }

    /**+
     * This method creates a string representation of the text
     * depending on which items were added to the list
     * @return string text
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();

        for (TextElement component : textComponentList) {
            if (component.getElementType() == TextElementType.PARAGRAPH) {
                resultString.append("\t");
            }
            if (component.getElementType() == TextElementType.LEXEMA) {
                resultString.append(" ");
            }
            if(component.getElementType() != TextElementType.WORD) {
                resultString.append(component.toString());
            }
            if(component.getElementType() == TextElementType.PARAGRAPH) {
                resultString.append("\n");
            }
        }
        return resultString.toString();
    }
}
