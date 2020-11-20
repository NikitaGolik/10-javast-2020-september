package by.golik.task09.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class CompositeTextElement implements TextElement {

    private final static Logger logger = LogManager.getLogger(CompositeTextElement.class);

    private ComponentType componentType;

    private List<TextElement> elementList = new ArrayList<>();

    public CompositeTextElement(ComponentType componentType) {
        this.componentType = componentType;
    }

    public List<TextElement> getElementList() {
        return elementList;
    }

    @Override
    public void add(TextElement component) {
        elementList.add(component);
    }

    @Override
    public void remove(TextElement component) {
        elementList.remove(component);
    }

    @Override
    public TextElement get(int i) {
        return elementList.get(i);
    }

    @Override
    public ComponentType getComponentType () {
        return componentType;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();

        for (TextElement textElement : elementList) {
            if (textElement.getComponentType() == ComponentType.SENTENCE) {
                resultString.append("\t");
            }
            if (textElement.getComponentType() == ComponentType.LEXEMA) {
                resultString.append(" ");
            }
            if (textElement.getComponentType() != ComponentType.WORD) {
                resultString.append(textElement.toString());
            }
            if (textElement.getComponentType() == ComponentType.PARAGRAPH) {
                resultString.append("\n");
            }
            if (textElement.getComponentType() == ComponentType.TEXT) {
                resultString.insert(0, "    ");

            }
            logger.info("in type {}, componentSize = {},  current SB = {}",
                    this.componentType.name(), elementList.size(), resultString.toString());

        } return resultString.toString();
    }

    @Override
    public void printToWriter(Writer writer) throws IOException {
        for (TextElement element : elementList) {
            element.printToWriter(writer);
        }
    }

}
