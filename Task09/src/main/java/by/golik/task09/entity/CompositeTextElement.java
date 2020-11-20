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

    public ComponentType getComponentType () {
        return componentType;
    }

    @Override
    public String create() {
        String delimeter;

        StringBuilder sb = new StringBuilder();

        switch (componentType){
            case PARAGRAPH: delimeter ="\n    "; break; // divisions for paragraphs
            case WORD: delimeter =" "; break; //devision for lexemas
            default: delimeter = ""; break;
        }

        for (int i =0; i< elementList.size(); i++){
            logger.info("in type {}, componentSize = {}, current element = {} current SB = {}",
                    this.componentType.name(), elementList.size(), i, sb.toString());
            sb.append(elementList.get(i).create());
        }

        if (this.componentType==ComponentType.TEXT){
            sb.insert(0,"    ");
        }

        return sb.append(delimeter).toString();
    }

    @Override
    public void printToWriter(Writer writer) throws IOException {
        for (TextElement element : elementList) {
            element.printToWriter(writer);
        }
    }

}
