package by.golik.task09.entity;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author Nikita Golik
 */
public class Symbol implements TextElement {

    private char symbol;

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
    public String create() {
        return String.valueOf(symbol);
    }

    public void printToWriter(Writer writer) throws IOException {
        writer.append(symbol);
    }

}
