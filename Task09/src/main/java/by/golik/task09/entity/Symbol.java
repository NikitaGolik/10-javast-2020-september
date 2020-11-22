package by.golik.task09.entity;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author Nikita Golik
 */
public class Symbol implements TextElement {

    private ComponentType componentType;
    private char symbol;

    public Symbol(String leafString, ComponentType componentType) {
        this.symbol = symbol;
        this.componentType = componentType;
    }


    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(TextElement component) {

    }

    @Override
    public void remove(TextElement component) {

    }

    @Override
    public TextElement get(int i) {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    public void printToWriter(Writer writer) throws IOException {
        writer.append(symbol);
    }

}
