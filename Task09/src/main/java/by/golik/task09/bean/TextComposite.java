package by.golik.task09.bean;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextElement {

    private List<TextElement> textComponentList = new LinkedList<>();
    private TextElementType elementType;

    public TextComposite(TextElementType elementType) {
        this.elementType = elementType;
    }

    public List<TextElement> getTextComponentList() {
        return textComponentList;
    }

    public int size() {
        return textComponentList.size();
    }

    public void add(TextElement textComponent) {
        textComponentList.add(textComponent);
    }

    @Override
    public TextElementType getElementType() {
        return elementType;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();

        for (TextElement component : textComponentList) {
            if (component.getElementType() == TextElementType.PARAGRAPH) {
                resultString.append("\t");
            }
            if (component.getElementType() == TextElementType.LEXEME) {
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
